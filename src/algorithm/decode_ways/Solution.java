package src.algorithm.decode_ways;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    Map<String, Integer> map;

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.startsWith("0")) return 0;
        char[] chars = s.toCharArray();
        int[] dp = new int[chars.length + 1];
        dp[chars.length] = 0;
        dp[chars.length - 1] = chars[chars.length - 1] == '0' ? 0 : 1;
        for (int i = chars.length - 2; i >= 0; --i) {
            if (chars[i] == '0') {
                dp[i] = 0;
            } else {
                dp[i] = dp[i + 1];
                int temp = (chars[i] - '0') * 10 + (chars[i + 1] - '0');
                dp[i] += (temp >= 1 && temp <= 26) ? i == chars.length - 2 ? 1 : dp[i + 2] : 0;
            }
        }
        return dp[0];
    }

    public int numDecodings2(String s) {
        map = new HashMap<>(s.length());
        return decode(s);
    }

    public int decode(String s) {
        if (map.containsKey(s)) return map.get(s);
        if (s == null || s.length() == 0) return 0;
        if (s.startsWith("0")) return 0;
        if (s.length() == 1) return 1;
        int count = 0;
        count += decode(s.substring(1));

        int temp = (s.charAt(0) - '0') * 10 + (s.charAt(1) - '0');
        if (s.length() == 2) {
            count += (temp >= 1 && temp <= 26 ? 1 : 0);
        } else {
            count += temp >= 1 && temp <= 26 ? decode(s.substring(2)) : 0;
        }
        map.put(s, count);
        return count;
    }

}
