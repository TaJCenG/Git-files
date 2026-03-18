package org.TajCeng;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MajorityElement {
    public static void main(String[] args) {
        int[] i = {1, 2, 3, 4, 1, 2, 1, 5};
        System.out.println(findMajorityElement(i));
    }

    private static Integer findMajorityElement(int[] array) {
        Map<Integer, Long> frequencyMap = Arrays.stream(array)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        int majorityCount = array.length / 2;

        return frequencyMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue() > majorityCount)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null); // Return null if no majority element is found
    }
}
