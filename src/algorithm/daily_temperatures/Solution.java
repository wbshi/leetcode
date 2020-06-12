package src.algorithm.daily_temperatures;

import java.util.Stack;

public class Solution {
    public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0) return new int[0];
        int len = T.length - 1;
        Stack<Integer> idxStack = new Stack<>();
        int[] res = new int[T.length];
        for (int i = len; i >= 0; --i) {
            if (idxStack.isEmpty()) {
                res[i] = 0;
            } else if (T[i] < T[idxStack.peek()]) {
                res[i] = 1;
            } else {
                while (!idxStack.isEmpty() && T[i] >= T[idxStack.peek()]) {
                    idxStack.pop();
                }
                res[i] = idxStack.isEmpty() ? 0 : idxStack.peek() - i;
            }
            idxStack.push(i);
        }
        return res;
    }
}
