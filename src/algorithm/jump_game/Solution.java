package src.algorithm.jump_game;

public class Solution {
    int[] visited;

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        visited = new int[nums.length];
        return jump(0, nums);
    }

    public boolean jump(int index, int[] nums) {
        if (visited[index] == 1) return false;
        visited[index] = 1;
        if (index == nums.length - 1) return true;
        if (nums[index] == 0) return false;
        boolean flag = false;
        for (int i = 1; i <= nums[index]; ++i) {
            if (index + i < nums.length && visited[index + i] != 1) {
                flag |= jump(index + i, nums);
            }
        }
        return flag;
    }
}
