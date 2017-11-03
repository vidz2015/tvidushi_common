package com.javarticles.threads;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockRecursiveLockExample {   
    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Thread firstThread = new Thread(new RecursiveLocksRunnable(), "FirstThread");
        firstThread.start();
        Thread secondThread = new Thread(new AcquireLockRunnable(), "SecondThread" );
        secondThread.start();
    }

    private static void print(String tag, String p) {
        System.out.println(Thread.currentThread().getName() + ": " + tag + ": " + p);
    }
    
    private static class RecursiveLocksRunnable implements Runnable {
        int level = 0;
        
        public void run() {
            try {
                someMethod();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void someMethod() throws InterruptedException {
            level++;
            print("RecursiveLocksRunnable.someMethod", "try lock(" + level + ")");
            lock.lock();
            print("RecursiveLocksRunnable.someMethod", "got lock(" + level + ")");
            try {
                if (level <= 3) {
                    someMethod();
                    if (level == 2) {
                        Thread.sleep(1000);
                    }
                } else {
                    Thread.sleep(1000);
                }

            } finally {
                print("RecursiveLocksRunnable.someMethod", "release lock(" + level + ")");
                lock.unlock();
                print("RecursiveLocksRunnable.someMethod", "lock(" + level + ") released");
                level--;
            }
        }
    }

    private static class AcquireLockRunnable implements Runnable {

        public void run() {
            print("AcquireLockRunnable", "try lock");
            lock.lock();
            print("AcquireLockRunnable", "got lock");
            try {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } finally {
                lock.unlock();
                print("AcquireLockRunnable", "unlocked");
            }
        }

    }

}
