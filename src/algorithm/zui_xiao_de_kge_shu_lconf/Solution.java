package src.algorithm.zui_xiao_de_kge_shu_lconf;

import java.util.Arrays;

public class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k >= arr.length) return arr;
        Arrays.sort(arr);
        return Arrays.copyOf(arr, k);
    }
}
