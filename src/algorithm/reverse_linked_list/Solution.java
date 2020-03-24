package src.algorithm.reverse_linked_list;

public class Solution {
    ListNode head1;

    //递归
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        reverse(head);
        return head1;
    }

    public ListNode reverse(ListNode node) {
        if (node.next == null) {
            head1 = node;
        }else {
            ListNode node1 = reverse(node.next);
            node1.next = node;
            node.next = null;
        }
        return node;
    }

    //迭代
    public ListNode reverseList2(ListNode head) {
        if (head == null) return null;
        ListNode ph = head;
        while (ph != null && ph.next != null) {
            ListNode temp = ph.next;
            if (ph.next != null) {
                ph.next = ph.next.next;
            }
            temp.next = head;
            head = temp;
        }
        return head;
    }
}
