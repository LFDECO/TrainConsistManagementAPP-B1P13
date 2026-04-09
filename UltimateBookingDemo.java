import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Ultimate Concurrent Hotel Booking System Demo
 * Shows:
 * 1. Race Condition (wrong)
 * 2. Synchronized fix
 * 3. BlockingQueue (Producer-Consumer)
 * 4. ReentrantLock
 * 5. ThreadPool + AtomicInteger
 * 
 * @author Siddhartha
 * @version 2.0
 */

class BookingRequest {
    String guestName;

    BookingRequest(String guestName) {
        this.guestName = guestName;
    }
}

/* ============================= */
/* ❌ 1. RACE CONDITION VERSION  */
/* ============================= */
class UnsafeBookingSystem {
    int availableRooms = 2;

    public void book(String guest) {
        if (availableRooms > 0) {
            System.out.println(Thread.currentThread().getName() +
                    " booking for " + guest);

            try { Thread.sleep(100); } catch (Exception e) {}

            availableRooms--; // NOT SAFE
            System.out.println("Booked " + guest +
                    " | Remaining: " + availableRooms);
        } else {
            System.out.println("No room for " + guest);
        }
    }
}

/* ============================= */
/* ✅ 2. SYNCHRONIZED VERSION   */
/* ============================= */
class SafeBookingSystem {
    int availableRooms = 2;

    public synchronized void book(String guest) {
        if (availableRooms > 0) {
            System.out.println(Thread.currentThread().getName() +
                    " booking for " + guest);

            try { Thread.sleep(100); } catch (Exception e) {}

            availableRooms--;
            System.out.println("Booked " + guest +
                    " | Remaining: " + availableRooms);
        } else {
            System.out.println("No room for " + guest);
        }
    }
}

/* ============================= */
/* ✅ 3. REENTRANT LOCK VERSION */
/* ============================= */
class LockBookingSystem {
    int availableRooms = 2;
    ReentrantLock lock = new ReentrantLock();

    public void book(String guest) {
        lock.lock();
        try {
            if (availableRooms > 0) {
                System.out.println(Thread.currentThread().getName() +
                        " booking for " + guest);

                try { Thread.sleep(100); } catch (Exception e) {}

                availableRooms--;
                System.out.println("Booked " + guest +
                        " | Remaining: " + availableRooms);
            } else {
                System.out.println("No room for " + guest);
            }
        } finally {
            lock.unlock();
        }
    }
}

/* ===================================== */
/* ✅ 4. BLOCKING QUEUE (PRODUCER-CONSUMER) */
/* ===================================== */
class QueueBookingSystem {
    BlockingQueue<BookingRequest> queue = new LinkedBlockingQueue<>();
    AtomicInteger availableRooms = new AtomicInteger(2);

    public void addRequest(String name) {
        queue.add(new BookingRequest(name));
    }

    public void process() {
        try {
            BookingRequest req = queue.take(); // thread-safe

            if (availableRooms.get() > 0) {
                System.out.println(Thread.currentThread().getName() +
                        " processing " + req.guestName);

                Thread.sleep(100);

                availableRooms.decrementAndGet();
                System.out.println("Booked " + req.guestName +
                        " | Remaining: " + availableRooms.get());
            } else {
                System.out.println("No room for " + req.guestName);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/* ============================= */
/* 🎯 MAIN DRIVER CLASS         */
/* ============================= */
public class UltimateBookingDemo {

    public static void main(String[] args) throws Exception {

        System.out.println("===== 1. RACE CONDITION =====");
        UnsafeBookingSystem unsafe = new UnsafeBookingSystem();

        Runnable task1 = () -> unsafe.book("Guest A");
        Runnable task2 = () -> unsafe.book("Guest B");

        new Thread(task1).start();
        new Thread(task2).start();

        Thread.sleep(500);

        System.out.println("\n===== 2. SYNCHRONIZED =====");
        SafeBookingSystem safe = new SafeBookingSystem();

        new Thread(() -> safe.book("Guest A")).start();
        new Thread(() -> safe.book("Guest B")).start();

        Thread.sleep(500);

        System.out.println("\n===== 3. REENTRANT LOCK =====");
        LockBookingSystem lockSys = new LockBookingSystem();

        new Thread(() -> lockSys.book("Guest A")).start();
        new Thread(() -> lockSys.book("Guest B")).start();

        Thread.sleep(500);

        System.out.println("\n===== 4. BLOCKING QUEUE + THREADPOOL =====");

        QueueBookingSystem queueSys = new QueueBookingSystem();

        // Producer (Guests)
        queueSys.addRequest("Guest A");
        queueSys.addRequest("Guest B");
        queueSys.addRequest("Guest C");

        // ThreadPool (Processors)
        ExecutorService executor = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 3; i++) {
            executor.submit(() -> queueSys.process());
        }

        executor.shutdown();
        executor.awaitTermination(2, TimeUnit.SECONDS);

        System.out.println("\n===== DONE =====");
    }
}