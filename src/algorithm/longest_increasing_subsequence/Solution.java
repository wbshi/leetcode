package src.algorithm.longest_increasing_subsequence;

import java.util.Arrays;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int max = 0;
        int[] d = new int[nums.length];
        Arrays.fill(d, 1);
        for (int i=0; i < nums.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i] )
                    d[i] = Math.max(d[i], d[j] + 1);
            }
            max = Math.max(d[i], max);
        }
        return max;
    }
}
