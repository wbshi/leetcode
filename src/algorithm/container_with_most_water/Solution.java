package src.algorithm.container_with_most_water;

public class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) return 0;

        int max = 0;

        for (int i = 1; i < height.length; ++i) {
            for (int j = 0; j < i; ++j) {
                int sum = (i - j) * Math.min(height[i], height[j]);
                max = Math.max(sum, max);
            }
        }
        return max;
    }
}
