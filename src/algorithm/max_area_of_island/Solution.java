package src.algorithm.max_area_of_island;

import java.util.Arrays;

public class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0) return 0;
        int[] preRow = new int[grid[0].length];
        int[] curRow = new int[grid[0].length];
        int max = 0;
        Arrays.fill(preRow, 0);
        Arrays.fill(curRow, 0);

        for (int i = 0; i< grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1) {
                    curRow[j] = 1 + preRow[j] + (j == 0? 0 : curRow[j - 1]);
                    max = Math.max(curRow[j], max);
                }
            }
            preRow = curRow.clone();
            Arrays.fill(curRow, 0);
            System.out.println("PRE:" + Arrays.toString(preRow));
            //System.out.println("CUR:" + Arrays.toString(curRow));
        }
        return max;
    }
}
