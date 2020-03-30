package src.algorithm.minimum_height_tree_lcci;

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }

    public TreeNode buildBST(int[] nums, int start, int end) {
        if (start > end) return null;
        int mid = (end - start) / 2 + start;
        TreeNode head = new TreeNode(nums[mid]);
        head.left = buildBST(nums, start, mid - 1);
        head.right = buildBST(nums, mid + 1, end);
        return head;
    }
}
