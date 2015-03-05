package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manshu on 3/4/15.
 */
public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        
        if (matrix.length == 0) return list;
        
        int m = matrix.length, n = matrix[0].length;
        int startRow = 0, endRow = m - 1, startCol = 0, endCol = n - 1;
        
        while (startRow <= endRow && startCol <= endCol) {
            System.out.println(startRow + " " + endRow + ", " + startCol + " " + endCol);
            for (int i = startCol; i <= endCol; i++)
                list.add(matrix[startRow][i]);

            for (int i = startRow + 1; i <= endRow; i++)
                list.add(matrix[i][endCol]);

            if (endRow != startRow)
            for (int i = endCol - 1; i >= startCol; i--)
                list.add(matrix[endRow][i]);

            if (endCol != startCol)
            for (int i = endRow - 1; i > startRow; i--)
                list.add(matrix[i][startCol]);
            
            startRow += 1; endRow -= 1; startCol += 1; endCol -= 1;
        }
        
        return list;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        
        int[][] matrix2 = {
            {1,},
            {2,},
            {3,},
            {4,},
            {5,},
            {6,},
            {7,},
            {8,},
            {9,},
            {10,},
        };
        List<Integer> spiral = spiralOrder(matrix2);
        System.out.println(spiral);
    }
}
