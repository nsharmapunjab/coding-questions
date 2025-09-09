package src.main.java.sdetinterviewquestions5;

import java.util.*;

public class SessionLogProcessor {

    public static List<SessionResult> processSessions(List<LogEvent> logs) {
        Map<String, Long> startTimes = new HashMap<>();
        Map<String, Long> interruptStart = new HashMap<>();
        Map<String, Long> totalInterrupted = new HashMap<>();
        List<SessionResult> results = new ArrayList<>();

        // Sort by timestamp to ensure order
        logs.sort(Comparator.comparingLong(l -> l.timestamp));

        for (LogEvent log : logs) {
            switch (log.eventType) {
                case "START":
                    startTimes.put(log.sessionId, log.timestamp);
                    totalInterrupted.put(log.sessionId, 0L);
                    break;

                case "INTERRUPT":
                    interruptStart.put(log.sessionId, log.timestamp);
                    break;

                case "RESUME":
                    if (interruptStart.containsKey(log.sessionId)) {
                        long interrupted = log.timestamp - interruptStart.get(log.sessionId);
                        totalInterrupted.put(log.sessionId,
                                totalInterrupted.getOrDefault(log.sessionId, 0L) + interrupted);
                        interruptStart.remove(log.sessionId);
                    }
                    break;

                case "STOP":
                    long start = startTimes.getOrDefault(log.sessionId, 0L);
                    long totalInterrupt = totalInterrupted.getOrDefault(log.sessionId, 0L);
                    long activeTime = (log.timestamp - start) - totalInterrupt;
                    results.add(new SessionResult(log.sessionId, activeTime));
                    break;
            }
        }
        return results;
    }

    public static void main(String[] args) {
        List<LogEvent> logs = Arrays.asList(
                new LogEvent("s1", "START", 1000),
                new LogEvent("s1", "INTERRUPT", 2000),
                new LogEvent("s1", "RESUME", 4000),
                new LogEvent("s1", "INTERRUPT", 5000),
                new LogEvent("s1", "RESUME", 6000),
                new LogEvent("s1", "STOP", 8000),
                new LogEvent("s2", "START", 1200),
                new LogEvent("s2", "STOP", 2200)
        );

        List<SessionResult> results = processSessions(logs);
        results.forEach(System.out::println);
    }
}

class LogEvent {
    String sessionId;
    String eventType;  // START, INTERRUPT, RESUME, STOP
    long timestamp;

    LogEvent(String sessionId, String eventType, long timestamp) {
        this.sessionId = sessionId;
        this.eventType = eventType;
        this.timestamp = timestamp;
    }
}

class SessionResult {
    String sessionId;
    long activeTime;

    SessionResult(String sessionId, long activeTime) {
        this.sessionId = sessionId;
        this.activeTime = activeTime;
    }

    @Override
    public String toString() {
        return "SessionId: " + sessionId + ", ActiveTime(ms): " + activeTime;
    }
}
