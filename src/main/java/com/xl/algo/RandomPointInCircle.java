package com.xl.algo;

import java.util.Arrays;
import java.util.Random;

public class RandomPointInCircle {
//    private double max_x;
//    private double max_y;
//    private double min_x;
//    private double min_y;
//
//    public RandomPointInCircle(double radius, double x_center, double y_center) {
//        max_x = x_center + radius;
//        min_x = x_center - radius;
//        max_y = y_center + radius;
//        min_y = y_center - radius;
//    }
//
//    public double[] randPoint() {
//        Random r1 = new Random();
//        Random r2 = new Random();
//        return new double[]{r1.nextDouble() * (max_x - min_x) + min_x, r2.nextDouble() * (max_y - min_y) + min_y};
//    }
    private double radius;
    private double x_center;
    private double y_center;

    public RandomPointInCircle(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }


    public double[] randPoint(){
        double rad = Math.sqrt(Math.random()) * radius;
        double deg = Math.random() * 2 * Math.PI;
        double x = rad * Math.cos(deg) + x_center;
        double y = rad * Math.sin(deg) + y_center;
        return new double[] {x, y};
    }

    public static void main(String[] args) {
        RandomPointInCircle rpic = new RandomPointInCircle(10.0,0, -7.5);
        System.out.println(Arrays.toString(rpic.randPoint()));
        System.out.println(Arrays.toString(rpic.randPoint()));
        System.out.println(Arrays.toString(rpic.randPoint()));
        Math.sqrt(0.1);
    }
}
