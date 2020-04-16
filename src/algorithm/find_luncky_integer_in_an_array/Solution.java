package src.algorithm.find_luncky_integer_in_an_array;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; ++i) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int ans = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getKey() == entry.getValue()) {
                ans = Math.max(ans, entry.getKey());
            }
        }

        return ans;
    }
}
