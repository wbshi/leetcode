package src.algorithm.er_cha_shu_de_jing_xiang_lconf;

public class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        TreeNode mirRoot = mirror(root);
        return mirRoot;
    }

    public TreeNode mirror(TreeNode source) {
        if (source == null) return null;
        TreeNode node = new TreeNode(source.val);
        if (node.left != null) node.right = mirror(node.left);
        if (node.right != null) node.left = mirror(node.right);
        return node;
    }
}
