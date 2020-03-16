package src.algorithm.compress_string_lcci;

public class Solution {
    public String compressString(String S) {
        int length = S.length();
        if (length == 0) return "";
        int count = 1;
        char curChar = S.charAt(0);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < length; ++i) {
            if (S.charAt(i) == curChar) {
                count ++;
            }
            else {
                sb.append(curChar);
                sb.append(count);
                curChar = S.charAt(i);
                count = 1;
            }

        }
        sb.append(curChar);
        sb.append(count);

        String ns = sb.toString();

       return ns.length() < length? ns : S;
    }
}
