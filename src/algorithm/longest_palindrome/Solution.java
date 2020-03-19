package src.algorithm.longest_palindrome;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int dd = 0;
        int ss = 0;
        for (int i = 0; i < s.length(); ++i) {
            Character c = Character.valueOf(s.charAt(i));
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Integer v : map.values()) {
            dd += v / 2;
            ss += v % 2;
        }
        return dd * 2 + ( ss > 0 ? 1 : 0);
    }
}
