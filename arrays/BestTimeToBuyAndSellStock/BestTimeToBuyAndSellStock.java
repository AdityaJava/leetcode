package leetcode.arrays.BestTimeToBuyAndSellStock;

public class BestTimeToBuyAndSellStock {

    private int bestTimeToBuyAndSellStock(int[] prices) {
        int minimumNumber = prices[0];
        int maxDifference = 0;
        int difference = 0;
        int buyingDay = 0;
        int sellingDay = 0;
        for (int i = 0; i < prices.length; i++) {
            if (minimumNumber > prices[i]) {
                minimumNumber = prices[i];
                buyingDay = i;
            }
            difference = prices[i] - minimumNumber;
            if (difference > maxDifference) {
                maxDifference = difference;
                sellingDay = i;
            }
        }

        //System.out.println("Best day to buy is " + buyingDay + 1 + " and best day to sell is " + sellingDay + 1);
        return maxDifference;
    }

    public static void main(String[] args) {
        int[] nums = {7, 1, 5, 3, 6, 4};
        BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();
        System.out.println("Max Difference is = " + bestTimeToBuyAndSellStock.bestTimeToBuyAndSellStock(nums));
    }
}
