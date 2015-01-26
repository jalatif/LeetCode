package DynamicProgramming;

/**
 * Created by manshu on 1/26/15.
 */
public class BestTimetoBuySellStock {

    private static class MMProfit {
        int profit;
        int max;
        int min;
        public MMProfit() {
            profit = 0;
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
        }
        
        public MMProfit(int a, int b, int c) {
            profit = a; max = b; min = c;
        }
    }
    
    private static MMProfit maxProfit(int[] prices, int i, int j) {
        if (i > j) return null;
        if (i < 0 || j >= prices.length) return null;
        if (i == j) return new MMProfit(0, prices[i], prices[i]);
        if (i + 1 == j) return (prices[j] - prices[i]) > 0 ? 
                new MMProfit((prices[j] - prices[i]), Math.max(prices[j], prices[i]), Math.min(prices[i], prices[j])) 
                : new MMProfit(0, Math.max(prices[j], prices[i]), Math.min(prices[i], prices[j]));
        
        int mid = i + (j - i) / 2;
        
        MMProfit mmProfit1 = maxProfit(prices, i, mid);
        MMProfit mmProfit2 = maxProfit(prices, mid + 1, j);
        
        int min = Math.min(mmProfit1.min, mmProfit2.min);
        int max = Math.max(mmProfit1.max, mmProfit2.max);
        int profit = Math.max(mmProfit1.profit, mmProfit2.profit);
        profit = Math.max(profit, (mmProfit2.max - mmProfit1.min));

        //System.out.println(min + " " + max + " " + profit);
        return new MMProfit(profit, max, min);
    }
    
    public static int maxProfit(int[] prices) {
        return maxProfit(prices, 0, prices.length - 1).profit;
    }

    public static void main(String[] args) {
        int arr[] = {5, 6, 8, 10, 5, 6, 5, 12, 8, 16};
        System.out.println(maxProfit(arr));
    }
}
