package sdetinterviewquestions3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestFailurePredictor {

    static class TestRun {
        String testName;
        LocalDateTime timestamp;
        String status;

        TestRun(String testName, LocalDateTime timestamp, String status) {
            this.testName = testName;
            this.timestamp = timestamp;
            this.status = status;
        }
    }

    public static void main(String[] args) throws Exception {
        String filePath = "test_history.csv";
        List<TestRun> history = readTestHistory(filePath);

        Map<String, List<TestRun>> grouped = groupByTestName(history);
        Map<String, Double> failureScores = calculateFailureScores(grouped);

        System.out.println("🔍 Predicted Likely-to-Fail Tests:");
        failureScores.entrySet().stream()
                .sorted((e1, e2) -> Double.compare(e2.getValue(), e1.getValue()))
                .forEach(entry -> {
                    String mark = entry.getValue() > 0.2 ? "⚠️ " : "✅ ";
                    System.out.printf("%s %s → score: %.3f%n", mark, entry.getKey(), entry.getValue());
                });
    }

    private static List<TestRun> readTestHistory(String filePath) throws Exception {
        List<TestRun> history = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line = reader.readLine(); // skip header

        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            String testName = parts[0];
            LocalDateTime timestamp = LocalDateTime.parse(parts[1], formatter);
            String status = parts[2].toUpperCase();
            history.add(new TestRun(testName, timestamp, status));
        }

        return history;
    }

    private static Map<String, List<TestRun>> groupByTestName(List<TestRun> runs) {
        Map<String, List<TestRun>> map = new HashMap<>();
        for (TestRun run : runs) {
            map.computeIfAbsent(run.testName, k -> new ArrayList<>()).add(run);
        }
        return map;
    }

    private static Map<String, Double> calculateFailureScores(Map<String, List<TestRun>> grouped) {
        Map<String, Double> scores = new HashMap<>();
        LocalDateTime now = LocalDateTime.now();

        for (Map.Entry<String, List<TestRun>> entry : grouped.entrySet()) {
            String testName = entry.getKey();
            List<TestRun> runs = entry.getValue();
            int totalRuns = runs.size();
            int failureCount = 0;
            double recencyScore = 0.0;

            for (TestRun run : runs) {
                if ("FAIL".equalsIgnoreCase(run.status)) {
                    failureCount++;
                    long daysAgo = Duration.between(run.timestamp, now).toDays() + 1;
                    recencyScore += 1.0 / daysAgo;
                }
            }

            double failureRate = (double) failureCount / totalRuns;
            double finalScore = 0.6 * failureRate + 0.4 * recencyScore;
            scores.put(testName, finalScore);
        }

        return scores;
    }
}
