package src.algorithm.zero_one_matrix;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int[][] updateMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[] dX = {-1, 1, 0, 0};
        int[] dY = {0, 0, -1, 1};
        Queue<Integer> queue = new LinkedList<>();
        int[][] seen = new int[row][col];
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (matrix[i][j] == 0) {
                    queue.offer(i * col + j);
                    seen[i][j] = 1;
                }
            }
        }

        while (!queue.isEmpty()) {
            Integer index = queue.poll();
            int x = index / col;
            int y = index % col;
            for (int i = 0; i < dX.length; ++i) {
                int nx = x + dX[i];
                int ny = y + dY[i];
                if (nx >= 0 && ny >= 0 && nx < row && ny < col && seen[nx][ny] != 1) {
                    matrix[nx][ny] = matrix[x][y] + 1;
                    seen[nx][ny] = 1;
                    queue.offer(nx * col + ny);
                }
            }
        }

        return matrix;
    }

}
