package com.xl.algo;

public class StrStr {
    public static void main(String[] args) {
        String haystack = "apple";
        String needle = "le";
        int pos = strStr2(haystack, needle);
        System.out.println("found at " + pos);

    }

    private static int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }

        int hashCode = needle.hashCode();
        for (int i = 0; i + needle.length() <= haystack.length(); i++){
            int hc = haystack.substring(i, i + needle.length()).hashCode();
            if (hc == hashCode) {
                if (haystack.substring(i, i + needle.length()).equals(needle)){
                    return i;
                }
            }
        }

        return -1;
    }

    private static int strStr2(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }

        for (int i = 0; i + needle.length() <= haystack.length(); i++){
            if (haystack.substring(i, i + needle.length()).equals(needle)){
                return i;
            }
        }

        return -1;
    }
}
