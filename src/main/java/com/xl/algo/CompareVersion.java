package com.xl.algo;

import java.util.HashMap;
import java.util.Map;

public class CompareVersion {

    public int compareVersion(String version1, String version2) {
        String[] ver1Ary = version1.split("\\.");
        String[] ver2Ary = version2.split("\\.");

        int index = 0;
        for (int i = 0; i < Math.max(ver1Ary.length, ver2Ary.length); i++) {
            String str1 = i < ver1Ary.length ? ver1Ary[i] : "";
            String str2 = i < ver2Ary.length ? ver2Ary[i] : "";

            int maxIndex = Math.max(str1.length(), str2.length());
            str1 = appendZero(maxIndex - str1.length()) + str1;
            str2 = appendZero(maxIndex - str2.length()) + str2;
            for (index = 0; index < maxIndex; index++) {
                if (str1.charAt(index) == str2.charAt(index)) {
                    continue;
                }
                return str1.charAt(index) > str2.charAt(index) ? 1 : -1;
            }
        }

        return 0;
    }

    public String appendZero(int i) {
        StringBuilder sb = new StringBuilder("");
        while(i-- > 0) {
            sb.append("0");
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.entrySet().stream()
                .sorted( (a,b) -> a.getKey() - b.getKey())
                .sorted().forEach( entry -> entry.getValue());
        return sb.toString();
    }

    public static void main(String[] args) {
        CompareVersion cv = new CompareVersion();
        System.out.println(cv.compareVersion("1.0.2.0", "1.0.2"));
    }
}
