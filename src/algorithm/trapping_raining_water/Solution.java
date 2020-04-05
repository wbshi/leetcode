package src.algorithm.trapping_raining_water;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int trap(int[] height) {
        if(height == null || height.length <= 2) return 0;
        List<Integer> list = new ArrayList<>();
        int ans = 0;
        boolean init = true;
        for(int i = 0; i < height.length; ++i) {
            if(init) {
                if(height[i] != 0) {
                    list.add(height[i]);
                    init = false;
                }
            }else {
                list.add(height[i]);
                if(height[i] >= list.get(0)) {
                    ans += countNum(list);
                    list.clear();
                    list.add(height[i]);
                }
            }
        }
        if(list.size() > 2) {
            ans += countNum(list);
        }
        return ans;
    }

    public int countNum(List<Integer> list) {
        System.out.println(list.toString());
        int length = list.size();
        int count = 0;
        if(list.get(0) <= list.get(length - 1)) {
            for(int i = 0; i < length - 1; ++i) {
                count += list.get(0) - list.get(i);
            }
        }else {
            Collections.reverse(list);
            count += trap(list.stream().mapToInt(Integer::valueOf).toArray());
        }
        return count;
    }
}