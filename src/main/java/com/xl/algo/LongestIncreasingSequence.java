package com.xl.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSequence {

	public int longestIncreasingSubsequence(int[] nums) {
		/*
		 * int[] f = new int[nums.length];
		 * 
		 * int max = 0; for (int i = 0; i < nums.length; i++){ f[i] = 1;
		 * 
		 * for (int j = 0; j < i; j++){ if (nums[j] < nums[i]){ f[i] = f[i] >
		 * f[j] + 1 ? f[i] : f[j] + 1; } }
		 * 
		 * if (f[i] > max){ max = f[i]; }
		 * 
		 * }
		 * 
		 * return max;
		 */

		int[] f = new int[nums.length];

		for (int i = 0; i < f.length; i++) {
			f[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < nums.length; i++) {
			int index = findNextLargerValue(f, nums[i]);
			f[index] = nums[i];
		}

		for (int i = nums.length - 1; i >= 0; i--) {
			if (f[i] != Integer.MAX_VALUE) {
				return i + 1;
			}
		}

		return 0;
	}

	public int findNextLargerValue(int[] f, int num) {
		int start = 0;
		int end = f.length - 1;

		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (f[mid] >= num) {
				end = mid;
			} else if (f[mid] < num) {
				start = mid;
			}
		}

		if (f[start] >= num) {
			return start;
		} else {
			return end;
		}
	}

	public static void main(String[] args) {
		LongestIncreasingSequence lis = new LongestIncreasingSequence();
		System.out.println(lis.longestIncreasingSubsequence(new int[] {8,4,3,1,6,7}));

	}

}
