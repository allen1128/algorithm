package com.xl.advanced;

import static java.lang.Thread.sleep;

public class TestMain {
    public static void main(String[] args) throws InterruptedException {
       String st1 = "a";
       String st2 = new String("a");
       st2 = st2.intern();

       System.out.println(st1 == st2 ? "true" : "false");


    }


}
