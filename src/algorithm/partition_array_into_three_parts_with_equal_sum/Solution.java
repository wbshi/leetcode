package src.algorithm.partition_array_into_three_parts_with_equal_sum;

public class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        if (A.length < 3) return false;
        int ap = 0;
        int bp = 0;
        int cp = 0;

        int i, j , k;
        for (i = 0; i < A.length - 2; ++ i) {
            ap += A[i];
            for (j = i + 1; j < A.length - 1; ++ j) {
                bp += A[j];
                if (bp == ap) break;
            }
            for (k = j + 1; k < A.length; ++ k) {
                cp += A[k];
            }
            if (cp == bp && cp == ap) {
                return true;
            }

            bp = 0;
            cp = 0;
        }
        return false;
    }
}
