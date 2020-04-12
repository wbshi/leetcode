package src.algorithm.ju_zhen_zhong_de_lu_jing_lcof;

public class Solution {
    int[] deltaR = {-1, 1, 0, 0};
    int[] deltaC = {0, 0, -1, 1};

    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) return true;
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                char[][] temp = boardCopy(board);
                if (dfs(temp, i, j, words, 0)) return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int row, int col, char[] words, int index) {
        if (index == words.length) return true;
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) return false;
        if (words[index] != board[row][col]) return false;
        System.out.println(row + ":" + col + ":" + board[row][col]);
        board[row][col] = ' ';

        boolean flag = false;
        for (int i = 0; i < deltaR.length; ++i) {
            char[][] temp = boardCopy(board);
            flag |= dfs(temp, row + deltaR[i], col + deltaC[i], words, index + 1);
        }
        return flag;
    }

    public char[][] boardCopy(char[][] board) {
        char[][] copy = new char[board.length][board[0].length];
        for (int k = 0; k < board.length; ++k) {
            System.arraycopy(board[k], 0, copy[k], 0, board[k].length);
        }
        return copy;
    }

    public void print(char[][] board) {
        System.out.print('[');
        for (int i = 0; i < board.length; ++i) {
            System.out.print('[');
            for (int j = 0; j < board[0].length; ++j) {
                System.out.print(board[i][j] + ", ");
            }
            System.out.print("],");
        }
        System.out.println("]");
    }


}
