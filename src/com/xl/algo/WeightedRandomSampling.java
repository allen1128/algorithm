package com.xl.algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Collections;

public class WeightedRandomSampling {
    public List<Double> cdf;

    public WeightedRandomSampling(List<Double> weights){
        cdf = new ArrayList<Double>(weights.size());
        calculateCdf(weights);
    }

    public List<Integer> getSamples(int num){
        List<Integer> result = new ArrayList<Integer>(num);
        Random random = new Random();
        for (int i = 0; i < num; i++){
            Double prob = random.nextDouble();
            result.add(getIndexInCdf(prob));
        }
        return result;
    }

    private void calculateCdf(List<Double> weights){
        Double totalWeight = 0.0d;
        for (Double weight : weights){
            totalWeight += weight;
        }

        Double accumulated = 0.0d;
        for (Double weight : weights){
            cdf.add(accumulated / totalWeight);
            accumulated += weight;
        }
    }

    private int getIndexInCdf(Double prob){
        int start = 0;
        int end = cdf.size() - 1;

        while (start + 1 < end){
            int mid = start + (end - start)/2;
            if (cdf.get(mid) > prob){
                end = mid;
            } else {
                start = mid;
            }
        }

        if (cdf.get(end) <= prob){
            return end;
        } else {
            return start;
        }
    }

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
