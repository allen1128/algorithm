package com.xl.algo.deepdive.array;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Integer maxCount = 0;
        Integer maxElement = null;
        for (Integer num : nums) {
            Integer count = map.getOrDefault(num, 0);
            map.put(num, ++count);
            if (count > maxCount) {
                maxCount = count;
                maxElement = num;
                if (maxCount > nums.length / 2) {
                    break;
                }
            }
        }
        return maxElement;
    }
}
