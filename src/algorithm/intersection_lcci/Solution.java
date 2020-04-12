package src.algorithm.intersection_lcci;

import java.util.Arrays;

public class Solution {
    public double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
        //特殊情况竖直平行判断
        if (end1[0] - start1[0] == 0 && end2[0] - start2[0] == 0) {
            if (start1[0] == start2[0]) {
                if (end1[1] < start1[1]) {
                    swap(start1, end1);
                }
                if (end2[1] < start2[1]) {
                    swap(start2, end2);
                }
                if (end1[1] < start2[1] || end2[1] < start1[1]) {
                    return new double[0];
                }

                if (start1[1] < start2[1]) {
                    return Arrays.stream(start2).asDoubleStream().toArray();
                } else {
                    return Arrays.stream(start1).asDoubleStream().toArray();
                }
            } else {
                return new double[0];
            }
        }

        if (start1[0] > end1[0]) {
            swap(start1, end1);
        }
        if (start2[0] > end2[0]) {
            swap(start2, end2);
        }

        if (end2[0] - start2[0] == 0) {
            swap(start1, start2);
            swap(end1, end2);
        }

        if (end1[0] - start1[0] == 0) {
            double k2 = (double) (end2[1] - start2[1]) / (end2[0] - start2[0]);
            double y = k2 * (start1[0] - start2[0]) + start2[1];
            if ((y >= start1[1] && y <= end1[1]) || (y >= end1[1] && y <= start1[1])) return new double[]{start1[0], y};
            return new double[0];
        }

        double k1 = (double) (end1[1] - start1[1]) / (end1[0] - start1[0]);
        double k2 = (double) (end2[1] - start2[1]) / (end2[0] - start2[0]);
        System.out.println(k1 + ":" + k2);

        //平行情况
        if (k1 == k2) {
            //重合情况
            if (k1 * (start2[0] - start1[0]) + start1[1] == start2[1]) {
                if (start1[0] > start2[0]) {
                    swap(start1, start2);
                    swap(end1, end2);
                }
                if (start1[0] <= start2[0] && end1[0] >= start2[0]) {
                    return Arrays.stream(start2).asDoubleStream().toArray();
                }
                return new double[0];
            }
            return new double[0];
        }

        double x = (k1 * start1[0] - k2 * start2[0] + start2[1] - start1[1]) / (k1 - k2);
        if (x < start1[0] || x > end1[0] || x < start2[0] || x > end2[0]) return new double[0];
        return new double[]{x, k1 * (x - start1[0]) + start1[1]};
    }

    public void swap(int[] start, int[] end) {
        for (int i = 0; i < start.length; ++i) {
            int temp = start[i];
            start[i] = end[i];
            end[i] = temp;
        }
    }
}
