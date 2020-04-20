package src.algorithm.palindrome_number;

public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return true;

        int k = 10;
        while (x / k > 9) {
            k *= 10;
        }

        while (k > 9) {
            if (x % 10 != x / k) return false;
            x /= 10;
            k /= 10;
            x %= k;
            k /= 10;
        }
        return true;
    }
}
