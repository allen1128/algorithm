package com.xl.algo;

import java.util.Stack;

public class HanoiTower {
    enum Tower {LEFT, RIGHT ,MID}
    static class HanoiObject {
        Tower src;
        Tower temp;
        Tower dest;
        int number;
        int index;

        public HanoiObject(Tower src, Tower temp, Tower dest, int number) {
            this.src = src;
            this.temp = temp;
            this.dest = dest;
            this.number = number;
            this.index = 1;
        }

        public HanoiObject(Tower src, Tower dest, int index) {
            this.src = src;
            this.dest = dest;
            this.index = index;
            this.number = 1;
        }

        @Override
        public String toString() {
            return "HanoiObject{" +
                    "src=" + src +
                    ", temp=" + temp +
                    ", dest=" + dest +
                    ", number=" + number +
                    ", index=" + index +
                    '}';
        }
    }

    public void move(HanoiObject object) {
        System.out.println(String.format("move element %s from %s to %s", object.index, object.src, object.dest));
    }
    public void solve(int n) {
        Stack<HanoiObject> stack = new Stack<>();
        HanoiObject object = new HanoiObject(Tower.LEFT, Tower.MID, Tower.RIGHT, n);
        stack.add(object);

        while (!stack.isEmpty()) {
            HanoiObject o = stack.pop();
            //System.out.println(o);

            if (o.number == 1) {
                move(o);
            } else {
                stack.add(new HanoiObject(o.temp, o.src, o.dest, o.number - 1));
                stack.add(new HanoiObject(o.src, o.dest, o.number)); //number is the index of the element
                stack.add(new HanoiObject(o.src, o.dest, o.temp, o.number - 1));
            }
        }
    }

    public static void main(String[] args){
        HanoiTower tower = new HanoiTower();
        tower.solve(3);
    }
}
