package src.algorithm.linked_list_cycle;

public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slowNode = head;
        ListNode fastNode = head;
        while (fastNode != null && fastNode.next != null) {
            if (fastNode.next == slowNode)
                return true;
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }
        return false;
    }
}
