package Greedy;

import java.util.Arrays;

/**
 * Created by manshu on 2/2/15.
 */
public class Candy {
    private static int candy(int[] ratings, int index) {
        if (index == ratings.length) return 0;
        if (index == 0 || ratings[index] <= ratings[index - 1]) {
            if (index == (ratings.length - 1) || ratings[index + 1] > ratings[index]) {
                ratings[index] = 1;
                candy(ratings, index + 1);
                return 1;
            } else {
                ratings[index] = 1 + candy(ratings, index + 1);
            }
        } else {
            ratings[index] = 1 + ratings[index - 1];
            candy(ratings, index + 1);
        }
        return 0;
    }
    
    public static int candy(int[] ratings) {
        //candy(ratings, 0);
        int[] candies = new int[ratings.length];
        candies[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1])
                candies[i] = candies[i - 1] + 1;
            else
                candies[i] = 1;
        }

        int numCandies = candies[ratings.length - 1];
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i + 1] > ratings[i])
                candies[i + 1] = Math.max(candies[i + 1], candies[i] + 1);
            numCandies += candies[i + 1];
        }
        
        //for (Integer i : ratings) System.out.print(i + " ");
        return numCandies;
    }
    
    public static void main(String[] args) {
        int[] ratings = {5, 4, 4, 3, 2, 7, 6 ,6, 4};
        System.out.println(candy(ratings));
    }
}
