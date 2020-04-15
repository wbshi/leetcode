package src.algorithm.remove_duplicates_from_sorted_array;

public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null) return 0;
        if (nums.length < 2) return nums.length;
        int n_ptr = 1; //新数组指针
        int duplicate = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] != duplicate) {
                nums[n_ptr] = nums[i];
                n_ptr++;
                duplicate = nums[i];
            }
        }
        return n_ptr;
    }
}
