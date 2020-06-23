package src.algorithm.add_binary;

public class Solution {
    public String addBinary(String a, String b) {
        if (a.charAt(0) == '0') return b;
        if (b.charAt(0) == '0') return a;

        int lena = a.length() - 1;
        int lenb = b.length() - 1;

        int flag = 0;
        StringBuilder sb = new StringBuilder();

        while (lena >= 0 && lenb >= 0) {
            int sum = a.charAt(lena) - '0' + b.charAt(lenb) - '0' + flag;
            sb.append(sum % 2);
            flag = sum / 2;
            lena--;
            lenb--;
        }

        if (lenb >= 0) {
            lena = lenb;
            a = b;
        }
        while (lena >= 0) {
            int sum = a.charAt(lena) - '0' + flag;
            sb.append(sum % 2);
            flag = sum / 2;
            lena--;
        }

        if (flag > 0) {
            sb.append(flag);
        }

        return sb.reverse().toString();
    }
}
