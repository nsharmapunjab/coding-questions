package src.main.java.arrayandstrings;

import java.util.Arrays;

public class Strcheck {

    public static int compareVersion(String version1, String version2) {
        String[] v1Parts = version1.split("\\.");
        String[] v2Parts = version2.split("\\.");

        int length = Math.max(v1Parts.length, v2Parts.length);

        for (int i = 0; i < length; i++) {
            int num1 = i < v1Parts.length ? Integer.parseInt(v1Parts[i]) : 0;
            int num2 = i < v2Parts.length ? Integer.parseInt(v2Parts[i]) : 0;

            if (num1 < num2) return -1;
            if (num1 > num2) return 1;
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(compareVersion("1.2", "1.10"));     // Output: -1
        System.out.println(compareVersion("1.01", "1.001"));   // Output: 0
        System.out.println(compareVersion("1.0", "1.0.1.0"));  // Output: 0
        System.out.println(compareVersion("2.1", "1.1"));      // Output: 1
    }

}
