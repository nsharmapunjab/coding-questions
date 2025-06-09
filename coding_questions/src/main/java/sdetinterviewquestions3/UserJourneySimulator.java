package sdetinterviewquestions3;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class UserJourneySimulator {

    private static final Map<String, List<String>> transitions = new HashMap<>();
    private static final Random random = new Random();
    private static final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

    static {
        transitions.put("visit_homepage", Arrays.asList("login", "browse_category", "search"));
        transitions.put("login", Arrays.asList("browse_category", "search", "logout"));
        transitions.put("browse_category", Arrays.asList("view_product", "search", "add_to_cart"));
        transitions.put("view_product", Arrays.asList("add_to_cart", "search", "browse_category"));
        transitions.put("search", Arrays.asList("view_product", "browse_category", "add_to_cart"));
        transitions.put("add_to_cart", Arrays.asList("checkout", "view_product", "search"));
        transitions.put("checkout", Collections.singletonList("logout"));
        transitions.put("logout", Collections.singletonList("visit_homepage"));
    }

    public static void main(String[] args) {
        int userCount = 3; // Simulate 3 users
        int maxSteps = 10;

        System.out.println("🚀 Starting User Journey Simulation...\n");

        for (int userId = 1; userId <= userCount; userId++) {
            simulateUserSession(userId, maxSteps);
        }

        System.out.println("✅ All user sessions completed.");
    }

    private static void simulateUserSession(int userId, int maxSteps) {
        System.out.printf("👤 Starting session for User-%d at %s\n", userId, timestamp());

        String currentAction = "visit_homepage";

        for (int step = 0; step < maxSteps; step++) {
            logAction(userId, currentAction);
            List<String> nextActions = transitions.getOrDefault(currentAction, Collections.emptyList());

            if (nextActions.isEmpty()) {
                break;
            }

            currentAction = nextActions.get(random.nextInt(nextActions.size()));

            try {
                Thread.sleep(500 + random.nextInt(1000)); // simulate think time
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }

        System.out.printf("👋 User-%d session ended.\n\n", userId);
    }

    private static void logAction(int userId, String action) {
        System.out.printf("[%s] User-%d → %s\n", timestamp(), userId, action);
    }

    private static String timestamp() {
        return timeFormat.format(new Date());
    }
}
