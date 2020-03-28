package src.algorithm.copy_list_with_random_pointer;

public class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Node temp = head;
        //在原链表上复制
        while (temp != null) {
            Node t = new Node(temp.val);
            t.next = temp.next;
            temp.next = t;
            temp = temp.next.next;
        }

        //添加random
        temp = head;
        Node nHead = head.next;
        Node nTemp = nHead;

        while (temp != null) {
            nTemp.random = temp.random == null? null :temp.random.next;
            temp = nTemp.next;
            nTemp = temp == null? null: temp.next;
        }

        //分离，还原现场
        temp = head;
        nTemp = nHead;
        while (temp != null) {
            temp.next = nTemp.next;
            temp = temp.next;
            if (temp == null) break;
            nTemp.next = temp.next;
            nTemp = nTemp.next;
        }

        return nHead;
    }
}
