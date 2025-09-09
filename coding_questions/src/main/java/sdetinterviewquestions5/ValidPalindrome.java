package src.main.java.sdetinterviewquestions5;

public class ValidPalindrome {

    public static void main(String[] args) {

        String s="A man, a plan, a canal: Panama";
        int start=0;
        int last=s.length()-1;
        boolean isPlaindrome = true;

        while (start<last) {

            if (!Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            }
            else if (!Character.isLetterOrDigit(s.charAt(last))) {
                last--;
            }

            else {
                if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(last))) {
                    isPlaindrome=false;
                    break;
                }
                start++;
                last--;
            }
        }

        System.out.println(isPlaindrome);
    }
}
