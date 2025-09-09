package sdetinterviewquestions3;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LoadRampUpSimulator {

    private static final int MAX_THREADS = 50; // Max simulated users
    private static final int RAMP_UP_STEP = 5; // New users per step
    private static final int STEP_DELAY_MS = 3000; // Delay between steps

    private static final ExecutorService executor = Executors.newCachedThreadPool();

    public static void main(String[] args) throws InterruptedException {
        System.out.println("🚀 Starting Load Ramp-Up Simulation...");

        for (int currentUsers = RAMP_UP_STEP; currentUsers <= MAX_THREADS; currentUsers += RAMP_UP_STEP) {
            System.out.printf("\n👥 Launching %d concurrent users...\n", currentUsers);
            
            for (int i = 0; i < RAMP_UP_STEP; i++) {
                executor.submit(LoadRampUpSimulator::simulateUserTask);
            }

            logSystemStats();

            Thread.sleep(STEP_DELAY_MS);
        }

        System.out.println("\n✅ Ramp-up complete. Shutting down executor.");
        executor.shutdown();
    }

    // Simulated workload: Replace with actual API call, DB op, etc.
    private static void simulateUserTask() {
        try {
            // Simulate work time (e.g., 1–3 seconds)
            long workTime = 1000L + (long)(Math.random() * 2000);
            Thread.sleep(workTime);
        } catch (InterruptedException ignored) {
        }
    }

    private static void logSystemStats() {
        OperatingSystemMXBean os = ManagementFactory.getOperatingSystemMXBean();
        Runtime runtime = Runtime.getRuntime();

        double cpuLoad = os.getSystemLoadAverage();
        long usedMemMB = (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024);
        long totalMemMB = runtime.totalMemory() / (1024 * 1024);

        System.out.printf("📊 CPU Load: %.2f | Used Mem: %dMB / %dMB\n", cpuLoad, usedMemMB, totalMemMB);
    }
}
