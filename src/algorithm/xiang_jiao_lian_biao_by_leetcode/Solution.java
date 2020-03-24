package src.algorithm.xiang_jiao_lian_biao_by_leetcode;


public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode A = headA;
        ListNode B = headB;
        boolean c = false;
        while (A != null || !c) {
            if (A == null) {
                A = headB;
                c = !c;
            }
            if (B == null) {
                B = headA;
            }
            if (A == B) return A;
            A = A.next;
            B = B.next;
        }
        return null;
    }
}
