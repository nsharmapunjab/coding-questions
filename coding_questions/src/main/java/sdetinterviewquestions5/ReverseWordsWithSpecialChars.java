package src.main.java.sdetinterviewquestions5;

public class ReverseWordsWithSpecialChars {

    public static void main(String[] args) {

        String s = "ab@cd#efg!";
        System.out.println("Input : " + s);
        char[] chrArr = s.toCharArray();

        int left=0;
        int right=s.length()-1;
        while (left < right) {
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            else if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            else {
                char tmp=chrArr[left];
                chrArr[left]=chrArr[right];
                chrArr[right]=tmp;
                left++;
                right--;
            }
        }

        System.out.println("Output : " + new String(chrArr));
    }
}
