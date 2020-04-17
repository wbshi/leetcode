package src.algorithm.binary_tree_maximum_path_sum;

public class Solution {

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return max;
    }

    public void dfs(TreeNode root) {
        if (root.left != null && root.right != null) {
            dfs(root.left);
            dfs(root.right);
            max = Math.max(max, root.left.val + root.right.val + root.val);
            root.val += Math.max(Math.max(root.left.val, root.right.val), 0);
        } else if (root.left != null) {
            dfs(root.left);
            root.val += root.left.val <= 0 ? 0 : root.left.val;
        } else if (root.right != null) {
            dfs(root.right);
            root.val += root.right.val <= 0 ? 0 : root.right.val;
        }

        max = Math.max(max, root.val);
    }
}
