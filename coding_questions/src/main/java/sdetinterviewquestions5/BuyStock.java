package src.main.java.sdetinterviewquestions5;

public class BuyStock {

    public static void main(String[] args) {

        int[] arr = {7,1,5,3,6,4};
        int buy=arr[0];
        int profit=0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - buy <0) {
                buy=arr[i];
            }
            else if (arr[i] - buy > profit){
                profit = arr[i] - buy;
            }
        }

        System.out.println(profit);
    }
}
