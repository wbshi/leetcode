package src.algorithm.diameter_of_binary_tree;

public class Solution {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        hdOfBinaryTree(root);
        return max;
    }

    public int hdOfBinaryTree(TreeNode root) {
        int ld, rd;
        ld = (root.left == null? 0 : hdOfBinaryTree(root.left) + 1);
        rd = (root.right == null? 0 : hdOfBinaryTree(root.right) + 1);

        if (ld + rd > max) max = ld + rd;
        return ld > rd? ld : rd;
    }
}
