package src.algorithm.count_number_of_nice_subarrays;

public class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int[] odds = new int[nums.length + 2];

        odds[0] = -1;
        int index = 1;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] % 2 != 0) {
                odds[index] = i;
                index++;
            }
        }
        odds[index] = nums.length;

        if (index <= k) {
            return 0;
        }

        int count = 0;

        for (int i = 1; i + k - 1 < index; ++i) {
            int left = odds[i] - odds[i - 1];
            int right = odds[i + k] - odds[i + k - 1];
            count += left * right;
        }

        return count;
    }
}
