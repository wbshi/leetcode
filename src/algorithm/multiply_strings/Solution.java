package src.algorithm.multiply_strings;

public class Solution {
    int[] ans;

    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) return "0";
        if (num1.charAt(0) == '0' || num2.charAt(0) == '0') return "0";

        ans = new int[num1.length() + num2.length()];

        for (int i = num2.length() - 1; i >= 0; --i) {
            singleMultiply(num1, num2.charAt(i) - '0', num2.length() - 1 - i);
        }

        StringBuilder sb = new StringBuilder(ans.length);
        boolean head = true;
        for (int i = ans.length - 1; i >= 0; --i) {
            if (head && ans[i] == 0) continue;
            sb.append(ans[i]);
            head = false;
        }

        return sb.toString();
    }

    public void singleMultiply(String num1, int n2, int index) {
        int flag = 0;
        int ai = 0;
        for (int i = num1.length() - 1; i >= 0; --i) {
            ai = num1.length() - 1 - i + index;
            int sum = (num1.charAt(i) - '0') * n2 + ans[ai] + flag;
            ans[ai] = sum % 10;
            flag = sum / 10;
        }

        while (flag != 0) {
            ans[++ai] = flag % 10;
            flag = flag / 10;
        }
    }
}
