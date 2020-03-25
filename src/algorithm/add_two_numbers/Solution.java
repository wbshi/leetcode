package src.algorithm.add_two_numbers;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head = new ListNode(-1);
        ListNode temp = head;
        int flag = 0;
        int sum;
        while (l1 != null || l2 != null) {
            sum = (l1 != null ?l1.val : 0) + (l2 != null ?l2.val : 0) + flag;
            temp.next = new ListNode(sum % 10);
            flag = sum / 10;
            l1 = l1 == null? l1 : l1.next;
            l2 = l2 == null? l2 : l2.next;
            temp = temp.next;
        }
        if (flag > 0) temp.next = new ListNode(flag);
        return head.next;
    }
}
