package src.algorithm.merge_two_sorted_lists;

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
                temp = temp.next;
            }else {
                temp.next = l2;
                l2 = l2.next;
                temp =temp.next;
            }
        }
        if (l1 == null)
            temp.next = l2;
        if (l2 == null)
            temp.next = l1;

        return head.next;
    }
}
