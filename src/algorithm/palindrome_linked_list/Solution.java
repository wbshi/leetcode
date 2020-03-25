package src.algorithm.palindrome_linked_list;

public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        //节点个数
        int count = 0;
        ListNode hp = head;
        while (hp != null) {
            count ++;
            hp = hp.next;
        }

        hp = head;
        //反转一半链表
        ListNode halfHead = null;
        ListNode temp;
        for (int i = 0; i < count / 2; ++ i) {
            temp = hp;
            hp = hp.next;
            temp.next = halfHead;
            halfHead = temp;
        }

        //比较
        if (count % 2 != 0) hp = hp.next;

        while (hp != null && halfHead != null) {
            if (hp.val != halfHead.val) return false;
            hp = hp.next;
            halfHead = halfHead.next;
        }
        return true;
    }
}
