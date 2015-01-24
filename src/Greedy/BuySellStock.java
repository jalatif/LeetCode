package Greedy;

/**
 * Created by manshu on 1/21/15.
 */
public class BuySellStock {
    public static int maxProfit(int[] prices) {
        int i = 0;
        int profit = 0;
        int purchase = 0;
        int sell = 0;
        if (prices.length == 1) return 0;
        while (i < prices.length) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) i++;
            if (i == prices.length - 1){
                if (prices[i - 1] < prices[i]) {
                    profit += prices[i] - prices[i - 1];
                }
                break;
            }
            purchase = prices[i];
            System.out.println("Purchase = " + purchase);
            sell = purchase;
            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) i++;
            if (i == prices.length - 1){
                if (prices[i - 1] < prices[i]) {
                    sell = prices[i];
                } else {
                    sell = prices[i - 1];
                }
                if (sell > purchase) {
                    profit += sell - purchase;
                }
                break;
            }
            sell = prices[i];
            System.out.println("Sell = " + sell);
            profit += sell - purchase;
        }
        return profit;
    }

    public static void main(String[] args) {
        int arr[] = {2, 35, 20, 18, 15, 22, 25, 40, 50, 30, 20};
        int arr2[] = {1, 2};
        System.out.println(maxProfit(arr2));
    }
}
