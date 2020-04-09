package src.algorithm.generate_parentheses;

import java.util.*;

public class Solution {
    Map<Integer, Set<String>> map = new HashMap<>();

    public List<String> generateParenthesis(int n) {
        Set<String> set = new HashSet<>(4);
        set.add("()");
        set.add("((");
        set.add("))");
        set.add(")(");
        map.put(1, set);
        List<String> list = dfs(n);
        Iterator<String> it = list.listIterator();
        while (it.hasNext()) {
            String s = it.next();
            if (!isValid(s)) {
                it.remove();
            }
        }
        return list;
    }

    public List<String> dfs(int n) {
        if (map.containsKey(n)) return new ArrayList<>(map.get(n));
        List<String> temp = dfs(n - 1);
        Set<String> set = new HashSet<>();
        for (String s : temp) {
            set.add("()" + s);
            set.add("((" + s);
            set.add("))" + s);
            set.add(")(" + s);
            set.add(s + "()");
            set.add(s + "((");
            set.add(s + "))");
            set.add(s + ")(");
            set.add("(" + s + ")");
            set.add(")" + s + "(");
            set.add("(" + s + "(");
            set.add(")" + s + ")");
        }
        return new ArrayList<>(set);
    }

    public boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') count++;
            else count--;
            if (count < 0) return false;
        }
        return count == 0;
    }
}
