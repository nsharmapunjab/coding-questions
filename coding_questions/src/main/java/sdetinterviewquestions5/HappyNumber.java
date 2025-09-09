package src.main.java.sdetinterviewquestions5;

public class HappyNumber {

    public static void main(String[] args) {

        int n = 19;
        System.out.print(isHappy(n));
    }

    public static boolean isHappy(int n) {
        if(n==1) {
            return true;
        }
        else if (n<10) {
            return false;
        }
        else{
            int sum=0;
            while(n>0){
                int temp=n%10;
                sum+= temp*temp;
                n=n/10;
            }
            return isHappy(sum);
        }
    }
}
