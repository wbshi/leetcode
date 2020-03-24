package src.algorithm.design_linked_list;

public class MyLinkedList {
    int length;
    Node head;
    public MyLinkedList() {
        length = 0;
        head = new Node(-1);
    }

    public int get(int index) {
        if (index < 0 || index >= length) return -1;
        Node temp = head;
        for (int i = 0; i < index + 1; ++i) {
            temp = temp.next;
        }
        System.out.println(temp.val);
        return temp.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(length, val);
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > length) return;
        Node node = new Node(val);
        Node temp = head;
        for (int i = 0; i < index; ++i) {
            temp = temp.next;
        }
        node.next = temp.next;
        temp.next = node;
        length ++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= length) return;
        Node temp = head;
        for (int i = 0; i < index; ++i) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        length --;
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.println();
    }

    class Node {
        int val;
        Node next;
        Node(int x) {val = x;}
    }

}

