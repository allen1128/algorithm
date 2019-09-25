package com.xl.algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShoppingOffer2 {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> specials, List<Integer> needs) {
        int cost = 0;

        Collections.sort(specials, (o1, o2) -> {
            Integer total1 = 0;
            Integer total2 = 0;
            for (int i = 0; i < o1.size() - 1; i++) {
                total1 += o1.get(i) * price.get(i);
                total2 += o2.get(i) * price.get(i);
            }
            return total2.compareTo(total1);
        });

//        Collections.partition(specials, (o1, o2) -> {
//            return o2.get(0)
//                    .compareTo(o1.get(0));
//        });
//
//        specials.stream()
//                .sorted( (o1, o2) -> {
//                    int total1 = 0;
//                    int total2 = 0;
//                    for (int i = 0; i < o1.size() - 1; i++) {
//                        total1 += o1.get(i) * price.get(i);
//                        total2 += o2.get(i) * price.get(i);
//                    }
//                    return total1 > total2  ? 1 : 0;
//                });

        for (List<Integer> special : specials) {
            int count = 0;
            while (true) {
                boolean valid = true;
                for (int i = 0; i < needs.size(); i++) {
                    if (needs.get(i) - special.get(i) * (count + 1) < 0) {
                        valid = false;
                        break;
                    }
                }
                if (valid) {
                    count++;
                } else {
                    break;
                }
            }

            if (count > 0) {
                for (int i = 0; i < needs.size(); i++) {
                    needs.set(i, needs.get(i) - special.get(i) * count);
                }
                cost += special.get(special.size() - 1) * count;
            }
        }

        for (int i = 0; i < needs.size(); i++) {
            cost += needs.get(i) * price.get(i);
        }

        return cost;
    }

    public static void main(String[] args) {
        ShoppingOffers so = new ShoppingOffers();
        List<Integer> price = new ArrayList<>();
        price.add(2);
        price.add(5);
        List<List<Integer>> specials = new ArrayList<>();
        List<Integer> special = new ArrayList<>();
        special.add(3);
        special.add(0);
        special.add(5);
        specials.add(special);

        special = new ArrayList<>();
        special.add(1);
        special.add(2);
        special.add(10);
        specials.add(special);

        List<Integer> needs = new ArrayList<>();
        needs.add(3);
        needs.add(2);

        System.out.println(so.shoppingOffers(price, specials, needs));
    }
}
