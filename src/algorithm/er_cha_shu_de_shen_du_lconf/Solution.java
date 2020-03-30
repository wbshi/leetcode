package src.algorithm.er_cha_shu_de_shen_du_lconf;

public class Solution {
    public int maxDepth(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int level) {
        if (root == null) return level;
        return Math.max(dfs(root.left, level + 1),dfs(root.right, level + 1));
    }
}
