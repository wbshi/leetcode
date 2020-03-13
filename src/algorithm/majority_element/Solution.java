package src.algorithm.majority_element;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int majorityElement(int[] nums) {
        int half = nums.length / 2;
        int count = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            count = countMap.getOrDefault(nums[i], 0);
            if (count + 1 > half) {
                return nums[i];
            }
            countMap.put(nums[i], count + 1);
        }
        return -1;
    }
}
