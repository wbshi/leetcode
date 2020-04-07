package src.algorithm.rotate_matrix_lcci;

public class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix.length == 1) return;
        int len = matrix.length - 1;
        int N = len / 2;
        for (int i = 0; i <= N; ++i) {
            for (int j = i; j < len - i; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len - j][i];
                matrix[len - j][i] = matrix[len - i][len - j];
                matrix[len - i][len - j] = matrix[j][len - i];
                matrix[j][len - i] = temp;
            }
        }
    }

    public void print(int[][] matrix){
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix.length; ++j) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
