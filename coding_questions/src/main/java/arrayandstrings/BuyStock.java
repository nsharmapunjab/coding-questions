package src.main.java.arrayandstrings;

import java.util.Arrays;

public class BuyStock {

    public static void main(String[] args) {

        int[] stocks = {7,1,5,3,6,4};

        int maxProfit = 0;
        int buyIndex = 0;
        int sellIndex = 0;
        for (int i = 0; i < stocks.length; i++) {
            for (int j = i+1; j < stocks.length; j++) {
                if (stocks[j]-stocks[i] > maxProfit) {
                    maxProfit = stocks[j]-stocks[i];
                    buyIndex = i;
                    sellIndex = j;
                }
            }
        }

        System.out.println(Arrays.toString(stocks));
        System.out.println("buyIndex : " + buyIndex);
        System.out.println("sellIndex : " + sellIndex);
        System.out.println("maxProfit : " + maxProfit);
    }

    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buy) {
                buy = prices[i];
            } else if (prices[i] - buy > profit) {
                profit = prices[i] - buy;
            }
        }
        return profit;
    }
}

