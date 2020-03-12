package src.algorithm.greatest_common_divisor_of_strings;

public class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (str1.isEmpty() || str2.isEmpty()) return "";

        String longer, shorter, divisor;
        if (str1.length() > str2.length()) {
            longer = str1;
            shorter = str2;
        }else {
            longer = str2;
            shorter = str1;
        }

        for (int i = shorter.length(); i > 0; --i) {
            if (shorter.length() % i != 0) continue;
            divisor = shorter.substring(0, i);
            if (isDivisor(shorter, divisor) && isDivisor(longer, divisor)) return divisor;
        }
        return "";
    }

    public boolean isDivisor(String source, String divisor) {
        if (divisor.isEmpty() || source.isEmpty()) return false;
        if (source.length() % divisor.length() != 0) return false;
        int count = source.length() / divisor.length();
        int length = divisor.length();
        for (int i = 0; i < count; ++i) {
            if (divisor.compareTo(source.substring(i * length, (i + 1) * length)) != 0) return false;
        }
        return true;
    }
}
