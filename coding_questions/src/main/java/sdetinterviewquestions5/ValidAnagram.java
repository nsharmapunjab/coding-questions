package src.main.java.sdetinterviewquestions5;

public class ValidAnagram {

    public static void main(String[] args) {

        String s1="anagram";
        String s2="nagaram";
        boolean isValid=true;

        int[] c1=new int[256];
        for (int i = 0; i < s1.length(); i++) {
            c1[s1.charAt(i)]++;
        }

        int[] c2=new int[256];
        for (int i = 0; i < s2.length(); i++) {
            c2[s2.charAt(i)]++;
        }

        for (int i = 0; i < c1.length; i++) {
            if (c1[i]!=c2[i]) {
                isValid=false;
            }
        }

        System.out.println(isValid);
    }
}
