package src.algorithm.find_duplicate_subtrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    Map<String, Integer> map = new HashMap<>();
    List<TreeNode> list = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        lookup(root);
        return list;
    }

    public String lookup(TreeNode node) {
        if (node == null) return "";
        String serial = node.val + "_"+ lookup(node.left) + "_" + lookup(node.right);
        map.put(serial, map.getOrDefault(serial, 0) + 1);
        if (map.get(serial) == 2) {
            list.add(node);
        }
        return serial;
    }
}
