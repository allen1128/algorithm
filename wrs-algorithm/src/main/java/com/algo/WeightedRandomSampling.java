package com.algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
}
