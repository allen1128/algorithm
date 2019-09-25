package com.xl.algo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ShoppingOffers {
    //WRONG SOLUTION because greedy algorithm doesn't yield the best solution. Backtracking should be used.
//    public int shoppingOffers(List<Integer> price, List<List<Integer>> specials, List<Integer> needs) {
//        int cost = 0;
//
//        for (int i = 0; i < price.size(); i++) {
//            Integer[] toadd = new Integer[price.size() + 1];
//            Arrays.fill(toadd, 0);
//            toadd[i] = 1;
//            toadd[toadd.length - 1] = price.get(i);
//            specials.add(Arrays.asList(toadd));
//        }
//
//        Collections.partition(specials, (o1, o2) -> {
//            Integer total1 = 0;
//            Integer total2 = 0;
//            for (int i = 0; i < o1.size() - 1; i++) {
//                total1 += o1.get(i) * price.get(i);
//                total2 += o2.get(i) * price.get(i);
//            }
//            total1 -= o1.get(o1.size()-1);
//            total2 -= o2.get(o2.size()-1);
//            return total2.compareTo(total1);
//        });
//
//        for (List<Integer> special : specials) {
//            int count = 0;
//            while (true) {
//                boolean valid = true;
//                for (int i = 0; i < needs.size(); i++) {
//                    if (needs.get(i) - special.get(i) * (count + 1) < 0) {
//                        valid = false;
//                        break;
//                    }
//                }
//                if (valid) {
//                    count++;
//                } else {
//                    break;
//                }
//            }
//            if (count > 0) {
//                for (int i = 0; i < needs.size(); i++) {
//                    needs.set(i, needs.get(i) - special.get(i) * count);
//                }
//                cost += special.get(special.size() - 1) * count;
//            }
//        }
//
//
//        for (int i = 0; i < needs.size(); i++) {
//            if (needs.get(i) > 0) {
//                throw new IllegalArgumentException();
//            }
//            cost += needs.get(i) * price.get(i);
//        }
//
//        return cost;
//    }

    //dynamic programming
    public int shoppingOffers(List<Integer> price, List<List<Integer>> specials, List<Integer> needs) {
        int sum = 0;
        for (int i = 0; i < needs.size(); i++) {
            sum += price.get(i) * needs.get(i);
        }

        //find the solution with specials.
        for (int i = 0; i < specials.size(); i++) {
            List<Integer> special = specials.get(i);
            boolean isValid = true;
            for (int j = 0; j < special.size() - 1; j++) {
                if (special.get(j) > needs.get(j)) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                for (int j = 0; j < special.size() - 1; j++) {
                    needs.set(j, needs.get(j) - special.get(j));
                }
                int lmax = shoppingOffers(price, specials, needs);
                sum = Math.min(sum, lmax + special.get(special.size()-1));

                for (int j = 0; j < special.size() - 1; j++) {
                    needs.set(j, needs.get(j) + special.get(j));
                }
            }
        }

        return sum;
    }


    public static void main(String[] args) {
        ShoppingOffers so = new ShoppingOffers();
        List<Integer> price = new ArrayList<>();
        price.add(2);
        price.add(3);
        price.add(4);
        List<List<Integer>> specials = new ArrayList<>();
        List<Integer> special = new ArrayList<>();
        special.add(1);
        special.add(1);
        special.add(0);
        special.add(4);
        specials.add(special);
        special = new ArrayList<>();
        special.add(2);
        special.add(2);
        special.add(1);
        special.add(9);
        specials.add(special);

        List<Integer> needs = new ArrayList<>();
        needs.add(1);
        needs.add(2);
        needs.add(1);

        System.out.println(so.shoppingOffers(price, specials, needs));
    }
}
