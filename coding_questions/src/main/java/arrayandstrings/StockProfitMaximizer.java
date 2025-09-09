package src.main.java.arrayandstrings;

import java.util.ArrayList;
import java.util.List;

public class StockProfitMaximizer {

    public static int maxProfit(int[] present, int[] future, int budget) {
        int n = present.length;

        // Step 1: Compute valid cost-profit pairs (only profitable ones)
        List<Integer> costs = new ArrayList<>();
        List<Integer> profits = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int profit = future[i] - present[i];
            if (profit > 0) {
                costs.add(present[i]);
                profits.add(profit);
            }
        }

        // Step 2: 0/1 Knapsack DP
        int[] dp = new int[budget + 1];

        for (int i = 0; i < costs.size(); i++) {
            int cost = costs.get(i);
            int profit = profits.get(i);

            // Iterate backward to avoid overwriting values needed in this round
            for (int b = budget; b >= cost; b--) {
                dp[b] = Math.max(dp[b], dp[b - cost] + profit);
            }
        }

        return dp[budget];
    }

    public static void main(String[] args) {
        int[] present = {5, 4, 6, 2, 3};
        int[] future = {8, 5, 4, 3, 5};
        int budget = 10;

        int result = maxProfit(present, future, budget);
        System.out.println("Maximum Profit: " + result);  // Output: 6
    }
}
