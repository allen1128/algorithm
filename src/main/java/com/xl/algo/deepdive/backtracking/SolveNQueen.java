package com.xl.algo.deepdive.backtracking;

import java.util.ArrayList;
import java.util.List;

public class SolveNQueen {
    List<List<String>> allSolutions = new ArrayList<>();

    public List<List<String>> solve(int n) {
        helper(0, new int[n]);
        return allSolutions;
    }

    private void toString(int[] result) {
        List<String> strResult = new ArrayList<>();
        for (int row = 0; row < result.length; row++) {
            StringBuilder sb = new StringBuilder();
            for (int col = 0; col < result.length; col++) {
                if (result[row] == col) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            strResult.add(sb.toString());
        }
        allSolutions.add(strResult);
    }
    public void helper(int row, int[] result) {
        if (row == result.length) {
            toString(result);
            return;
        }

        for (int column = 0; column < result.length; column++) {
            if (isOk(row, column, result)) {
                result[row] = column;
                helper(row + 1, result);
            }
        }
    }

    public boolean isOk(int row, int column, int[] result) {
        int leftup = column - 1;
        int rightup = column + 1;

        for (int i = row - 1; i >= 0; i--) {
            if (result[i] == column) {
                return false;
            }
            if (leftup >= 0 && result[i] == leftup) {
                return false;
            }
            if (rightup < result.length && result[i] == rightup) {
                return false;
            }
            leftup--;
            rightup++;
        }

        return true;
    }

    public static void main(String[] args) {
        SolveNQueen eq = new SolveNQueen();
        List<List<String>> result = eq.solve(0);
        System.out.println(result.size());
        System.out.println(result);
    }
}
