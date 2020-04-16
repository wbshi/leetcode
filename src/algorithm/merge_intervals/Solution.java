package src.algorithm.merge_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length < 2) return intervals;

        //根据左边界排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        //记录新数组
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);

        for (int i = 1; i < intervals.length; ++i) {
            int[] temp = list.get(list.size() - 1);
            if (intervals[i][0] <= temp[1]) {
                //如果左边界小于等于当前的右边界，且右边界大于当前的右边界，则更新右边界, 否则继续
                if (intervals[i][1] > temp[1]) {
                    temp[1] = intervals[i][1];
                    list.remove(list.size() - 1);
                    list.add(temp);
                }
            } else {
                //如果左边界大于当前的右边界，则说明没重合，添加到新数组中
                list.add(intervals[i]);
            }
        }

        //将新数组返回
        return list.toArray(new int[list.size()][2]);
    }
}
