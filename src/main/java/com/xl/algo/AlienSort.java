package com.xl.algo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class AlienSort {
    public String alienOrder(String[] words) {
        StringBuilder result = new StringBuilder();

        Map<Character, Set<Character>> map = new HashMap<>();
        Map<Character, Integer> degree = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                degree.put(c, 0);
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String curr = words[i];
            String next = words[i + 1];

            int length = Math.min(curr.length(), next.length());
            for (int j = 0; j < length; j++) {
                char c1 = curr.charAt(j);
                char c2 = next.charAt(j);

                if (c1 != c2) {
                    Set<Character> p = map.get(c1);
                    if (p == null) {
                        p = new HashSet<>();
                        map.put(curr.charAt(j), p);
                    }
                    if (!p.contains(c2)) {
                        p.add(c2);
                        degree.put(c2, degree.get(c2)+1);
                    }

                    break;
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();
        for (Character c : degree.keySet()) {
            if (degree.get(c) == 0) {
                queue.offer(c);
            }
        }

        while (!queue.isEmpty()) {
            Character c = queue.poll();
            result.append(c);
            if (map.get(c) != null) {
                for (Character cha : map.get(c)) {
                    degree.put(cha, degree.get(cha) - 1);
                    if (degree.get(cha) == 0) {
                        queue.offer(cha);
                    }
                }
            }
        }

        return result.length() == degree.entrySet().size() ? result.toString() : "";

    }

    public String alienOrder2(String[] words) {
        Map<Character, Set<Character>> map=new HashMap<Character, Set<Character>>();
        Map<Character, Integer> degree=new HashMap<Character, Integer>();
        String result="";
        if(words==null || words.length==0) return result;
        for(String s: words){
            for(char c: s.toCharArray()){
                degree.put(c,0);
            }
        }
        for(int i=0; i<words.length-1; i++){
            String cur=words[i];
            String next=words[i+1];
            int length=Math.min(cur.length(), next.length());
            for(int j=0; j<length; j++){
                char c1=cur.charAt(j);
                char c2=next.charAt(j);
                if(c1!=c2){
                    Set<Character> set=new HashSet<Character>();
                    if(map.containsKey(c1)) set=map.get(c1);
                    if(!set.contains(c2)){
                        set.add(c2);
                        map.put(c1, set);
                        degree.put(c2, degree.get(c2)+1);
                    }
                    break;
                }
            }
        }
        Queue<Character> q=new LinkedList<Character>();
        for(char c: degree.keySet()){
            if(degree.get(c)==0) q.add(c);
        }
        while(!q.isEmpty()){
            char c=q.remove();
            result+=c;
            if(map.containsKey(c)){
                for(char c2: map.get(c)){
                    degree.put(c2,degree.get(c2)-1);
                    if(degree.get(c2)==0) q.add(c2);
                }
            }
        }
        if(result.length()!=degree.size()) return "";
        return result;
    }

    public static void main(String[] args) {
        AlienSort as = new AlienSort();
        System.out.println(as.alienOrder(new String[] {"za","zb","ca","cb"}));
    }
}
