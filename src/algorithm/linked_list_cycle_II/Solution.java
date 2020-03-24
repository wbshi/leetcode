package src.algorithm.linked_list_cycle_II;

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fastNode = head;
        ListNode slowNode = head;
        while (fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
            if (fastNode == slowNode)
                break;
        }

        if (fastNode == null || fastNode.next == null) return null;
        slowNode = head;
        while (fastNode != slowNode) {
            slowNode = slowNode.next;
            fastNode = fastNode.next;
        }
        return slowNode;
    }

}
