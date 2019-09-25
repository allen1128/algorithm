package com.xl.algo;

public class AllCombinGivenAListOfString {
    public int solve(String tiles) {
        int[] freq = new int[26];
        for (char c : tiles.toCharArray()) {
            freq[c-'A']++;
        }

        return helper(freq);
    }

    public int helper(int[] freq) {
        int sum = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == 0) {
                continue;
            }

            freq[i]--;
            sum++;
            sum+=helper(freq);
            freq[i]++;
        }
        return sum;
    }

    public static void main(String[] args) {
        AllCombinGivenAListOfString acgal = new AllCombinGivenAListOfString();
        System.out.println(acgal.solve("AAABBC"));

    }
}
