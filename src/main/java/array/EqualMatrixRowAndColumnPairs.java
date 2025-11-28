package array;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EqualMatrixRowAndColumnPairs {

    public static int equalPairs(int[][] grid) {
        int n = grid.length;
        Map<String, Integer> map = new HashMap<>();

        // Count rows
        for (int i = 0; i < n; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < n; j++) {
                row.append(grid[i][j]).append(",");
            }
            String rowStr = row.toString();
            map.put(rowStr, map.getOrDefault(rowStr, 0) + 1);
        }

        // Count columns and sum the matches
        int count = 0;
        for (int j = 0; j < n; j++) {
            StringBuilder col = new StringBuilder();
            for (int i = 0; i < n; i++) {
                col.append(grid[i][j]).append(",");
            }
            String colStr = col.toString();
            count += map.getOrDefault(colStr, 0);
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println("enter row size:");
        Scanner s1 = new Scanner(System.in);
        int row = s1.nextInt();
        System.out.println("enter column size:");
        Scanner s2 = new Scanner(System.in);
        int column = s2.nextInt();
        int[][] grid = new int[row][column];
        for (int i = 0; i < row; i++) {
            System.out.println("enter numbers:");
            for (int j = 0; j < column; j++) {
                Scanner s3 = new Scanner(System.in);
                grid[i][j] = s3.nextInt();
            }
        }

        System.out.println("equals pair is: " + EqualMatrixRowAndColumnPairs.equalPairs(grid));
    }

}