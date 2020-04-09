package src.algorithm.dinner_plate_stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DinnerPlates {
    int capacity;
    List<Stack<Integer>> list;
    int size;
    int left;
    int right;

    public DinnerPlates(int capacity) {
        this.capacity = capacity;
        list = new ArrayList<>();
        size = 0; //list大小
        left = 0; //最左边未满
        right = -1; //最右边未空

    }

    public void push(int val) {
        if (left < size) {
            list.get(left).push(val);
            while (left < size && list.get(left).size() == capacity) {
                left++;
            }
            if (left < size - 1 && right < left) {
                right = list.get(left).size() == 0 ? left - 1 : left;
            } else if (left >= size) {
                right = size - 1;
            }
        } else {
            Stack<Integer> stack = new Stack<>();
            stack.push(val);
            list.add(stack);
            size++;
            if (list.get(left).size() == capacity) left++;
            right = size - 1;
        }
    }

    public int pop() {
        if (right == 0 && list.get(right).size() == 0) {
            return -1;
        }
        int res = list.get(right).pop();
        while (list.get(right).size() == 0 && right > 0) {
            right--;
        }
        if (left > right && list.get(right).size() != capacity) left = right;
        return res;
    }

    public int popAtStack(int index) {
        if (index == right) return pop();
        if (index >= list.size()) return -1;
        if (list.get(index).size() > 0) {
            int res = list.get(index).pop();
            if (left > index) left = index;
            if (right < index) right = list.get(index).size() == 0 ? index - 1 : index;
            return res;
        }
        return -1;
    }
}
