package src.algorithm.count_the_repetitions;

import java.util.HashMap;

public class Solution {
    int init_count = 0;
    int init_n2_count = 0;
    int count = 1;
    int n2_count = 0;
    HashMap<Integer, Integer> map = new HashMap<>();

    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        findRepetitions(s1, s2);
        if (count == 0) return 0;

        int n1_use = (n1 - init_count) / count;
        int n1_left = (n1 - init_count) % count + init_count;

        System.out.println("MA:" + n1_left);
        int n2_has = n1_use * n2_count + map.getOrDefault(n1_left, 0);

        int ans = n2_has / n2;

        return ans;
    }

    public void findRepetitions(String s1, String s2) {
        int idx = findEnd(s1, 0, s2);
        if (idx == -1) return;
        init_count = count;
        init_n2_count = n2_count;
        System.out.println("LC1:" + count + "  N2:" + n2_count);
        int temp = idx;
        while ((temp = findEnd(s1, temp, s2)) != idx) ;
        count -= init_count;
        n2_count -= init_n2_count;
        System.out.println("LC:" + count + "  N2:" + n2_count);
    }

    public int findEnd(String s1, int index, String s2) {
        for (int i = 0; i < s2.length(); ++i) {
            int idx = s1.indexOf(s2.charAt(i), index);
            if (idx == -1) {
                if (index == -1) {
                    return -1;
                } else {
                    map.put(count, n2_count);
                    count++;
                    index = 0;
                    idx = s1.indexOf(s2.charAt(i), index);
                    if (idx == -1) {
                        return -1;
                    } else {
                        index = idx + 1;
                    }
                }
            } else {
                index = idx + 1;
            }
        }
        n2_count++;
        System.out.println("Index:" + index + "  Count:" + count);
        return index;
    }
}
