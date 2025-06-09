package sdetinterviewquestions3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import junit.framework.TestCase;

public class TestScheduler {

    private final List<TestCase> testCases;

    public TestScheduler(List<TestCase> testCases) {
        this.testCases = testCases;
    }

    public void scheduleAndRun() {
        Collections.sort(testCases); // Prioritize by failure count
        System.out.println("📋 Scheduled Test Execution Order:");

        for (TestCase test : testCases) {
            System.out.println("➡️ Running: " + test);
            runTest(test);
        }
    }

    private void runTest(TestCase test) {
        // Simulate test execution
        try {
            Thread.sleep(500); // Simulate run time
            System.out.println("✅ Completed: " + test.getName());
        } catch (InterruptedException e) {
            System.out.println("❌ Interrupted: " + test.getName());
        }
    }

    // Load test metadata from a file, DB, or mock
    public static List<TestCase> loadTestHistory() {
        return Arrays.asList(
            new TestCase("LoginTest", 3),
            new TestCase("SearchTest", 1),
            new TestCase("PaymentTest", 5),
            new TestCase("CartTest", 0),
            new TestCase("RegistrationTest", 2)
        );
    }

    public static class TestCase implements Comparable<TestCase> {
        private final String name;
        private final int failureCount;
    
        public TestCase(String name, int failureCount) {
            this.name = name;
            this.failureCount = failureCount;
        }
    
        public String getName() {
            return name;
        }
    
        public int getFailureCount() {
            return failureCount;
        }
    
        @Override
        public int compareTo(TestCase other) {
            // Descending by failure count
            return Integer.compare(other.failureCount, this.failureCount);
        }
    
        @Override
        public String toString() {
            return name + " (failures: " + failureCount + ")";
        }
    }

    public static void main(String[] args) {
        List<TestCase> tests = loadTestHistory();
        new TestScheduler(tests).scheduleAndRun();
    }
}
