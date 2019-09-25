package com.xl.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReorderLogFiles {
    public String[] reorderLogFiles2(String[] logs) {
        List<String> letterLogs = new ArrayList<>();
        List<String> digitsLogs = new ArrayList<>();

        for (String log : logs) {
            String[] words = log.split(" ");
            if (Character.isLetter(words[1].charAt(0))) {
                letterLogs.add(log);
            } else {
                digitsLogs.add(log);
            }
        }

        letterLogs.sort((l1, l2) -> {
            String[] words1 = l1.split(" ");
            String[] words2 = l2.split(" ");
            for (int i = 1; i < Math.min(words1.length, words2.length); i++) {
                if (!words1[i].equals(words2[i])) {
                    return words1[i].compareTo(words2[i]);
                }
            }

            return words1[0].compareTo(words2[0]);
        });

        letterLogs.addAll(digitsLogs);
        return letterLogs.toArray(new String[0]);
    }

    public String[] reorderLogFiles(String[] logs) {

        Arrays.sort(logs, (l1, l2) -> {
            String[] words1 = l1.split(" ");
            String[] words2 = l2.split(" ");
            boolean isLetter1 = Character.isLetter(words1[1].charAt(0));
            boolean isLetter2 = Character.isLetter(words2[1].charAt(0));

            if (isLetter1 && isLetter2) {
                for (int i = 1; i < Math.min(words1.length, words2.length); i++) {
                    if (!words1[i].equals(words2[i])) {
                        return words1[i].compareTo(words2[i]);
                    }
                }
                return words1[0].compareTo(words2[0]);
            } else if (isLetter1 && !isLetter2) {
                return -1;
            } else if (!isLetter1 && isLetter2) {
                return 1;
            } else {
                return 0;
            }



        });

        return logs;
    }

    public static void main(String[] args) {
        ReorderLogFiles rlf = new ReorderLogFiles();
        System.out.println(Arrays.toString(rlf.reorderLogFiles2(new String[] {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"})));
        System.out.println(Arrays.toString(rlf.reorderLogFiles(new String[] {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"})));
    }
}
