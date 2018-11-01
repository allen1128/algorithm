package com.xl.algo;

public class SmallestPositive {

	public int solution(int[] A) {
		int result = 1;
		
        boolean[] marker = new boolean[100000];
        for (int i = 0; i < A.length; i++){
        	if (A[i] > 0){
        		marker[A[i]] = true;
        	}
        };
        
        for (int i = 1; i < A.length; i++){
        	if (!marker[i]){
        		result = i;
        		break;
        	}
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		SmallestPositive sp = new SmallestPositive();
		System.out.println(sp.solution(new int[]{-1,-3, 0}));
	}
}

