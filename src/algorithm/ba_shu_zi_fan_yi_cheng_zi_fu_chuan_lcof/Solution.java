package src.algorithm.ba_shu_zi_fan_yi_cheng_zi_fu_chuan_lcof;

public class Solution {
    public int translateNum(int num) {
        if (num == 0) return 1;
        int cur = num % 10;
        int nn = num / 10;
        if (nn == 0) {
            return 1;
        }
        int pre = nn % 10;
        if (pre == 1 || (pre == 2 && cur < 6)) {
            return translateNum(nn) + translateNum(nn / 10);
        }

        return translateNum(nn);
    }
}
