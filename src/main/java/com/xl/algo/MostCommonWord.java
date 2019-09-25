package com.xl.algo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> freq = new HashMap<>();
        Set<String> ban = Arrays.stream(banned).collect(Collectors.toSet());


        StringBuilder sb = new StringBuilder();
        int max = 0;
        String maxWord = "";
        String newparagraph = paragraph + " ";
        for (char c : newparagraph.toCharArray()) {
            if (Character.isLetter(c)) {
                sb.append(c);
            } else if (sb.length() > 0){
                String str = sb.toString().toLowerCase();
                if (!ban.contains(str)) {
                    Integer count = freq.getOrDefault(str, 0);
                    count++;
                    freq.put(str,count);
                    if (count > max) {
                        max = count;
                        maxWord = str;
                    }
                }
                sb = new StringBuilder();
            }
        }

        return maxWord;
    }

    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < emails.length; i++) {
            int del = emails[i].lastIndexOf("@");
            int plus = emails[i].indexOf("+");
            if (plus != -1 && plus < del) {
                set.add(emails[i].substring(0, plus).replaceAll("\\.","") + emails[i].substring(del, emails[i].length()));
            } else {
                set.add(emails[i].substring(0, del).replaceAll("\\.","")  + emails[i].substring(del, emails[i].length()));
            }
        }
        return set.size();
    }


    public static void main(String[] args) {
        MostCommonWord mcw = new MostCommonWord();
        mcw.numUniqueEmails(new String[] {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"});
    }
}
