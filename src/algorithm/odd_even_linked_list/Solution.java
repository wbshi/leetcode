package src.algorithm.odd_even_linked_list;

public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode oddHead = head;
        ListNode evenHead = head.next;
        ListNode oddPtr = head;
        ListNode evenPtr = head.next;
        while (evenPtr != null && evenPtr.next != null) {
            oddPtr.next = evenPtr.next;
            evenPtr.next = oddPtr.next.next;
            oddPtr.next.next = evenHead;
            oddPtr = oddPtr.next;
            evenPtr = evenPtr.next;
        }
        return oddHead;
    }
}
