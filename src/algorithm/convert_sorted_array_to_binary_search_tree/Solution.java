package src.algorithm.convert_sorted_array_to_binary_search_tree;

public class Solution {
    int[] nums;
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        this.nums = nums;
        int length = nums.length;
        return buildTree(0, length - 1);

    }

    public TreeNode buildTree(int start, int end) {
        if (start > end) return null;
        int mid = (end - start) /2 + start;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildTree(start, mid - 1);
        node.right = buildTree(mid + 1, end);
        return node;
    }
}
