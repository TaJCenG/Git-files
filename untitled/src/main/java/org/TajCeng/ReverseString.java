package org.TajCeng;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseString {
    public static void main(String[] args) {

        String normalString = " Normal String";
        StringBuilder reverseString = new StringBuilder(normalString).reverse();
        System.out.println(reverseString);
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 1, 3, 9, 8, 9, 10);
        List<Integer> filterList = list.stream().
                sorted((b,a)->(a-b)).distinct().skip(2).limit(2).collect(Collectors.toList());
        System.out.println(filterList);

    }
}
