package src.algorithm.binary_tree_maximum_path_sum;

public class Solution {

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int left_sum = dfs(root.left);
        int right_sum = dfs(root.right);

        max = Math.max(max, left_sum + right_sum + root.val);

        root.val += Math.max(Math.max(left_sum, right_sum), 0);
        max = Math.max(max, root.val);
        return root.val;
    }
}
