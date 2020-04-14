package src.algorithm.add_two_numbers_ii;

import java.util.Stack;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l1.val == 0) return l2;
        if (l2 == null || l2.val == 0) return l1;

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        ListNode head = null;
        int flag = 0;

        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            int sum = stack1.pop() + stack2.pop() + flag;
            ListNode node = new ListNode(sum % 10);
            node.next = head;
            head = node;
            flag = sum / 10;
        }
        while (!stack1.isEmpty()) {
            int sum = stack1.pop() + flag;
            ListNode node = new ListNode(sum % 10);
            node.next = head;
            head = node;
            flag = sum / 10;
        }

        while (!stack2.isEmpty()) {
            int sum = stack2.pop() + flag;
            ListNode node = new ListNode(sum % 10);
            node.next = head;
            head = node;
            flag = sum / 10;
        }

        if (flag > 0) {
            ListNode node = new ListNode(flag);
            node.next = head;
            head = node;
        }
        return head;

    }
}
