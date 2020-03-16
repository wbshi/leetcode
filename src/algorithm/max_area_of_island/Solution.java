package src.algorithm.max_area_of_island;

import java.util.Arrays;

public class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0) return 0;
        int max = 0;


        for (int i = 0; i< grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                System.out.println("CUR:" + i + ":" + j);
                if (grid[i][j] == 1) {
                    max = Math.max(max, dfs(grid, i, j));
                }
            }
        }
        return max;
    }

    public int dfs(int[][] grid, int row, int col) {
        System.out.println(row + ":" + col);
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0)
            return 0;
        int count = 1;
        grid[row][col] = 0;
        count += dfs(grid, row - 1, col);
        count += dfs(grid, row, col - 1);
        count += dfs(grid, row + 1, col);
        count += dfs(grid, row, col + 1);

        return count;
    }
}
