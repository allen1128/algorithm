package com.algo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args){
        List<Double> weights = new ArrayList<Double>();
        weights.add(0.1);
        weights.add(0.2);
        weights.add(0.3);
        weights.add(0.4);
        weights.add(0.7);

        WeightedRandomSampling wrs = new WeightedRandomSampling(weights);

        int sampleSize = 50;
        List<Integer> indexes= wrs.getSamples(sampleSize);
        Collections.sort(indexes);

        int[] samples = new int[weights.size()];
        for (int i = 0; i < indexes.size(); i++){
            samples[indexes.get(i)]++;
        }

        for (int i = 0; i < samples.length; i++){
            System.out.println(samples[i] / Double.valueOf(sampleSize));
        }

    }
}
