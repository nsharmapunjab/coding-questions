package sdetinterviewquestions3;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogErrorDetector {

    // Define your error pattern here
    private static final Pattern ERROR_PATTERN = Pattern.compile("(?i)(ERROR|Exception|Failed|Critical)");

    public static void detectErrorsInLog(String filePath) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
            String line;
            int lineNum = 1;
            boolean foundErrors = false;

            while ((line = reader.readLine()) != null) {
                Matcher matcher = ERROR_PATTERN.matcher(line);
                if (matcher.find()) {
                    System.out.printf("⚠️  Error found at line %d: %s%n", lineNum, line);
                    foundErrors = true;
                }
                lineNum++;
            }

            if (!foundErrors) {
                System.out.println("✅ No errors found in the log.");
            }
        } catch (IOException e) {
            System.err.println("❌ Error reading log file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Change this path to your actual log file location
        String logFilePath = "logs/app.log";
        detectErrorsInLog(logFilePath);
    }
}
