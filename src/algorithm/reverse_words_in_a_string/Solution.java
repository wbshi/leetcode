package src.algorithm.reverse_words_in_a_string;

public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;
        String[] strArr = s.trim().split(" ");
        if (strArr.length == 0) return "";
        StringBuilder sb = new StringBuilder(s.length());
        for (int i = strArr.length - 1; i >= 0; --i) {
            if (strArr[i].trim().length() != 0) {
                sb.append(strArr[i]);
                sb.append(" ");
            }
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
