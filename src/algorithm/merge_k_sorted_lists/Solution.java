package src.algorithm.merge_k_sorted_lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode prev = new ListNode(0);
        ListNode temp = prev;
        List<ListNode> list = new ArrayList<ListNode>(Arrays.asList(lists));
        while (!list.isEmpty()) {
            int index = findLeast(list);
            if (index == -1) break;
            ListNode node = list.get(index);
            list.remove(index);
            temp.next = node;
            node = node.next;
            temp = temp.next;
            if (node != null) list.add(node);

        }
        return prev.next;
    }

    public int findLeast(List<ListNode> list) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < list.size(); ++i) {
            if (list.get(i) != null && list.get(i).val < min) {
                min = list.get(i).val;
                index = i;
            }
        }
        return index;
    }
}
