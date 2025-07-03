package sdetinterviewquestions4;

public class StringToIntegerConverter {

    public static int stringToInt(String str) {
        if (str == null || str.isEmpty()) throw new IllegalArgumentException("Invalid input");

        int num = 0;
        int sign = 1;
        int i = 0;

        // Handle optional sign
        if (str.charAt(0) == '-') {
            sign = -1;
            i++;
        } else if (str.charAt(0) == '+') {
            i++;
        }

        for (; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') throw new NumberFormatException("Invalid character: " + c);

            num = num * 10 + (c - '0');  // core logic
        }

        return sign * num;
    }

    public static void main(String[] args) {
        String input = "-4567";
        int result = stringToInt(input);
        System.out.println("Converted number: " + result);
    }
}
