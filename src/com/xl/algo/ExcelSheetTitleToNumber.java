package com.xl.algo;

public class ExcelSheetTitleToNumber {
    public int titleToNumber(String s) {
        int result = 0;
        if (s.length() == 0){
            return result;
        }

        for (int i = 0; i < s.length() - 1; i++){
            result += (int) s.charAt(i) - 64;
            result = result * 26;
        }

        return result+(int) s.charAt(s.length() - 1) -64;
    }

    public static void main(String[] args){
        ExcelSheetTitleToNumber estn = new ExcelSheetTitleToNumber();
        System.out.println(estn.titleToNumber("A"));
    }
}
