package src.algorithm.rotate_list;

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode ptr = head;
        ListNode nptr = head;
        int length = 0;
        while (k > 0 && ptr != null) {
            k--;
            length++;
            ptr = ptr.next;
        }

        if (k > 0) {
            k %= length;
            ptr = head;
            while (k > 0) {
                k--;
                ptr = ptr.next;
            }
        }

        if (k == 0 && ptr == null) return head;

        while (ptr.next != null) {
            ptr = ptr.next;
            nptr = nptr.next;
        }

        ptr.next = head;
        head = nptr.next;
        nptr.next = null;

        return head;
    }
}
