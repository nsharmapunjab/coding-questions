package sdetinterviewquestions4;

public class LongestSubSeq {

    /**
     * Finds the longest common subsequence between two strings
     * @param text1 First input string
     * @param text2 Second input string
     * @return The longest common subsequence as a string
     */
    public static String findLCS(String text1, String text2) {
        if (text1 == null || text2 == null || text1.isEmpty() || text2.isEmpty()) {
            return "";
        }
        
        int m = text1.length();
        int n = text2.length();
        
        // dp[i][j] represents the length of LCS of text1[0..i-1] and text2[0..j-1]
        int[][] dp = new int[m + 1][n + 1];
        
        // Fill the dp table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        // Reconstruct the LCS string
        StringBuilder lcs = new StringBuilder();
        int i = m, j = n;
        
        while (i > 0 && j > 0) {
            if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                lcs.insert(0, text1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        
        return lcs.toString();
    }
    
    public static void main(String[] args) {
        // Test case 1: Example from the problem statement
        String text1 = "ABCBDAB";
        String text2 = "BDCAB";
        System.out.println("String 1: " + text1);
        System.out.println("String 2: " + text2);
        System.out.println("Longest Common Subsequence: " + findLCS(text1, text2));
        
        // Test case 2: No common characters
        text1 = "ABC";
        text2 = "XYZ";
        System.out.println("\nString 1: " + text1);
        System.out.println("String 2: " + text2);
        System.out.println("Longest Common Subsequence: " + 
            (findLCS(text1, text2).isEmpty() ? "<empty>" : findLCS(text1, text2)));
        
        // Test case 3: One string is empty
        text1 = "ABCD";
        text2 = "";
        System.out.println("\nString 1: " + text1);
        System.out.println("String 2: " + text2);
        System.out.println("Longest Common Subsequence: " + 
            (findLCS(text1, text2).isEmpty() ? "<empty>" : findLCS(text1, text2)));
        
        // Test case 4: Both strings are identical
        text1 = "ABCDEF";
        text2 = "ABCDEF";
        System.out.println("\nString 1: " + text1);
        System.out.println("String 2: " + text2);
        System.out.println("Longest Common Subsequence: " + findLCS(text1, text2));
    }
}
