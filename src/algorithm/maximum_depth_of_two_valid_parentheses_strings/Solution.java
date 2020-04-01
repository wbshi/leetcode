package src.algorithm.maximum_depth_of_two_valid_parentheses_strings;

public class Solution {

    public int[] maxDepthAfterSplit(String seq) {
        int[] ans = new int[seq.length()];
        int a = 0, b = 0;
        for (int i = 0; i < seq.length(); ++i) {
            if (seq.charAt(i) == '(') {
                if (a < b) {
                    ans[i] = 0;
                    a++;
                }else {
                    ans[i] = 1;
                    b++;
                }
            }else if (seq.charAt(i) == ')') {
                if (a < b) {
                    ans[i] = 1;
                    b --;
                }else {
                    ans[i] = 0;
                    a --;
                }
            }
        }
        return ans;
    }
}
