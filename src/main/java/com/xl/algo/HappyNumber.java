package com.xl.algo;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();
        visited.add(n);

        while (true) {
            int res = 0;
            while (n > 0) {
                int mod = n % 10;
                res += mod * mod;
                n = n / 10;
            }

            if (res == 1) {
                return true;
            }

            if (visited.contains(res)) {
                break;
            }

            visited.add(res);
            n = res;
        }

        return false;
    }

    public static void main(String[] args) {
        HappyNumber hn = new HappyNumber();
        System.out.println(hn.isHappy(19));
    }

}
