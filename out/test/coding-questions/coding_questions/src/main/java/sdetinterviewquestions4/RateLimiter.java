package sdetinterviewquestions4;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RateLimiter {

    private final int k; // max requests per user per minute
    private final long WINDOW_SIZE_MS = 60 * 1000; // 1 minute
    private final Map<String, Deque<Long>> userRequestMap;

    public RateLimiter(int k) {
        this.k = k;
        this.userRequestMap = new ConcurrentHashMap<>();
    }

    public boolean allowRequest(String userId) {
        long currentTime = System.currentTimeMillis();
        userRequestMap.putIfAbsent(userId, new ArrayDeque<>());

        Deque<Long> timestamps = userRequestMap.get(userId);

        synchronized (timestamps) {
            // Remove timestamps older than 1 minute
            while (!timestamps.isEmpty() && currentTime - timestamps.peekFirst() > WINDOW_SIZE_MS) {
                timestamps.pollFirst();
            }

            if (timestamps.size() < k) {
                timestamps.offerLast(currentTime);
                return true;
            } else {
                return false;
            }
        }
    }

    // Test
    public static void main(String[] args) throws InterruptedException {
        RateLimiter limiter = new RateLimiter(3); // max 3 requests per minute
        String user = "user1";

        // Simulate 4 rapid requests
        for (int i = 0; i < 4; i++) {
            boolean allowed = limiter.allowRequest(user);
            System.out.println("Request " + (i + 1) + ": " + (allowed ? "Allowed" : "Blocked"));
            Thread.sleep(200); // simulate a short gap
        }

        // Wait a minute to reset
        System.out.println("Waiting 61 seconds...");
        Thread.sleep(61000);

        boolean allowed = limiter.allowRequest(user);
        System.out.println("Request after 61 seconds: " + (allowed ? "Allowed" : "Blocked"));
    }
}
