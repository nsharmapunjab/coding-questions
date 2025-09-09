package sdetinterviewquestions4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SpecialCharacterChecker {

    public static void main(String[] args) {
        String input = "Hello@World123";

        // This regular expression will match any character that is not alphanumeric
        // in the input string.
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            System.out.println("Yes");

        }
        else {
            System.out.println("No");
        }
    }
}
