package src.algorithm.remove_nth_node_from_end_of_list;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) return null;
        ListNode fastNode = head;
        ListNode slowNode = head;
        for (int i = 0; i < n; ++ i) {
            fastNode = fastNode.next;
        }
        if (fastNode == null) {
            head = head.next;
            return head;
        }
        while (fastNode.next != null) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        slowNode.next = slowNode.next.next;
        return head;
    }
}
