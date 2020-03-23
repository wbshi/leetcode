package src.algorithm.middle_of_the_linked_list;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public ListNode middleNode(ListNode head) {
        if (head == null) return null;
        int length = 1;
        List<ListNode> list = new ArrayList<>();
        list.add(head);
        while (head.next != null) {
            length ++;
            list.add(head.next);
            head = head.next;
        }
        return list.get(length / 2);
    }
}
