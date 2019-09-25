package com.xl.algo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SumII {
    public int fourSumCount2(int[] A, int[] B, int[] C, int[] D) {
        int result = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        Arrays.sort(C);
        Arrays.sort(D);


        for (int i = 0; i < A.length; i++) {
            int res2 = 0;
            for (int j = 0; j < B.length; j++) {
                int res3 = 0;
                for (int u = 0; u < C.length; u++) {
                    int res4 = 0;
                    for (int v = 0; v < D.length; v++) {
                        if (A[i] + B[j] + C[u] + D[v] == 0) {
                            res4++;
                        }
                    }
                    res3 += res4;
                    while (u < C.length - 1 && C[u] == C[u + 1]) {
                        u++;
                        res3 += res4;
                    }
                }
                res2 += res3;
                while (j < B.length - 1 && B[j] == B[j + 1]) {
                    j++;
                    res2 += res3;
                }
            }
            result += res2;
            while (i < A.length - 1 && A[i] == A[i + 1]) {
                i++;
                result += res2;
            }
        }
        return result;
    }

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int result = 0;
        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                long sum = (long) A[i] + B[j];
                Integer ans = map.get(sum);
                if (ans != null) {
                    map.put(sum, ans++);
                } else {
                    map.put(sum, 1);
                }
            }
        }
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                long sum = -((long) C[i] + D[j]);
                Integer ans = map.get(sum);
                if (ans != null) {
                    result += ans;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SumII sumII = new SumII();
        System.out.println(sumII.fourSumCount(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2}));
    }
}
