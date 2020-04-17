package src.algorithm.sorted_list;

public class Solution {
    public ListNode sortList(ListNode head) {
        ListNode prev = new ListNode(0);
        prev.next = head;
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        System.out.println(count);
        quickSort(prev, head, count);
        return prev.next;
    }

    public void quickSort(ListNode prev, ListNode node, int count) {
        if (count < 2) return;
        int left_count = 0;
        int right_count = 0;
        ListNode temp = node;
        ListNode temp_next = node.next;
        ListNode prev_temp = prev;
        while (--count > 0) {
            if (temp_next.val < node.val) {
                prev_temp.next = temp_next;
                temp_next = temp_next.next;
                prev_temp = prev_temp.next;
                prev_temp.next = node;
                temp.next = temp_next;
                left_count++;
            } else {
                temp = temp_next;
                temp_next = temp_next.next;
                right_count++;
            }
        }
        quickSort(prev, prev.next, left_count);
        quickSort(node, node.next, right_count);
    }
}
