package src.algorithm.permutations;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    Map<Integer, Integer> map;
    int len;
    List<List<Integer>> ans;

    public List<List<Integer>> permute(int[] nums) {
        len = nums.length;
        map = new HashMap<>(len);
        map.put(0, 1);
        for (int i = 1; i <= len; ++i) {
            map.put(i, map.getOrDefault(i - 1, 1) * i);
        }

        ans = new ArrayList<>();
        for (int i = 0; i < map.get(len); ++i) {
            ans.add(new ArrayList<>());
        }

        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        dfs(0, 0, list);
        return ans;
    }


    /**
     * @param index
     * @param left
     * @param list
     */
    public void dfs(int index, int left, List<Integer> list) {
        if (list.size() == 0 || index == len) return;
        int jie = map.get(len - 1 - index);
        System.out.println(index + ":" + (len - 1 - index) + ":" + jie);
        for (int i = 0; i < list.size(); ++i) {
            for (int j = 0; j < jie; ++j) {
                int idx = left + i * jie + j;
                ans.get(idx).add(index, list.get(i));
            }
            List<Integer> newList = new ArrayList<>(list);
            newList.remove(i);
            dfs(index + 1, left + jie * i, newList);
        }
    }
}
