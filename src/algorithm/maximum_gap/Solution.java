package src.algorithm.maximum_gap;

import java.util.Arrays;

public class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        Arrays.sort(nums);
        int max = 0;
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i + 1] - nums[i] > max) {
                max = nums[i + 1] - nums[i];
            }
        }
        return max;
    }
}
