package src.algorithm.three_sum_closest;

import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) return 0;

        Arrays.sort(nums);

        int ans = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; ++i) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (Math.abs(sum - target) < Math.abs(ans - target)) {
                    ans = sum;
                }
                if (sum > target) {
                    end--;
                } else if (sum < target) {
                    start++;
                } else {
                    return sum;
                }
            }
        }
        return ans;
    }

    public int threeSumClosest2(int[] nums, int target) {
        if (nums == null || nums.length < 3) return 0;
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; ++i) {
            for (int j = i + 1; j < nums.length - 1; ++j) {
                for (int k = j + 1; k < nums.length; ++k) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum == target) return sum;
                    if (Math.abs(sum - target) < Math.abs(ans - target)) {
                        ans = sum;
                    }
                }
            }
        }

        return ans;
    }
}
