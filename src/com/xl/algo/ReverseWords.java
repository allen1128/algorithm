package com.xl.algo;

/*

    Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.

    The input string does not contain leading or trailing spaces and the words are always separated by a single space.

    For example,
    Given s = "the sky is blue",
    return "blue is sky the".

    Could you do it in-place without allocating extra space?


    Swapping left substring with right substring is not a viable solution although it might seem to be promising at the first glance.
    For this type of question, write down the reverse words in paper together with the original words and try to find the connections.
    The solution is just reversing the whole array and then reversing back each word.

 */
public class ReverseWords {
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length - 1);

        int start = 0;
        for (int i = 0; i < s.length; i++){
            if (s[i] == ' '){
                reverse(s, start,i - 1);
                start = i + 1;
            }
        }

        reverse(s, start, s.length - 1);
    }

    public void reverse(char[] s, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            char temp = s[j];
            s[j] = s[i];
            s[i] = temp;
        }
    }

    public static void main(String[] args){
        ReverseWords rw = new ReverseWords();
        char[] s = "ABC EFG EE TT".toCharArray();
        rw.reverseWords(s);
        System.out.println(s);
    }
}
