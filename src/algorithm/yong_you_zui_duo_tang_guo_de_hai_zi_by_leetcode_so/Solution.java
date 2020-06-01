package src.algorithm.yong_you_zui_duo_tang_guo_de_hai_zi_by_leetcode_so;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int i : candies) {
            max = Math.max(i, max);
        }

        List<Boolean> result = new ArrayList<>();
        for (int i : candies) {
            result.add(i + extraCandies >= max);
        }

        return result;
    }
}
