package sdetinterviewquestions3;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class DeadlockDetector {

    // Simulated shared resources
    private static final Object RESOURCE_1 = new Object();
    private static final Object RESOURCE_2 = new Object();

    public static void main(String[] args) {
        Thread agent1 = new Thread(() -> {
            synchronized (RESOURCE_1) {
                System.out.println("Agent-1 locked RESOURCE_1");
                try { Thread.sleep(100); } catch (InterruptedException ignored) {}

                synchronized (RESOURCE_2) {
                    System.out.println("Agent-1 locked RESOURCE_2");
                }
            }
        });

        Thread agent2 = new Thread(() -> {
            synchronized (RESOURCE_2) {
                System.out.println("Agent-2 locked RESOURCE_2");
                try { Thread.sleep(100); } catch (InterruptedException ignored) {}

                synchronized (RESOURCE_1) {
                    System.out.println("Agent-2 locked RESOURCE_1");
                }
            }
        });

        agent1.start();
        agent2.start();

        // Start deadlock detector thread
        new Thread(() -> {
            ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

            while (true) {
                long[] deadlockedThreadIds = threadMXBean.findDeadlockedThreads();

                if (deadlockedThreadIds != null && deadlockedThreadIds.length > 0) {
                    System.err.println("⚠️ DEADLOCK DETECTED!");
                    ThreadInfo[] infos = threadMXBean.getThreadInfo(deadlockedThreadIds);

                    for (ThreadInfo info : infos) {
                        System.err.println("Thread name: " + info.getThreadName());
                        System.err.println("Locked on: " + info.getLockName());
                        System.err.println("Waiting for: " + info.getLockOwnerName());
                        System.err.println("Stack Trace:");
                        for (StackTraceElement ste : info.getStackTrace()) {
                            System.err.println("\tat " + ste);
                        }
                    }
                    break;
                }

                try {
                    Thread.sleep(500); // Check every half-second
                } catch (InterruptedException ignored) {}
            }
        }).start();
    }
}
