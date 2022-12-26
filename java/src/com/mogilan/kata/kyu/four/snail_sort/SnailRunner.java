package com.mogilan.kata.kyu.four.snail_sort;

import java.util.Arrays;

public class SnailRunner {
    public static void main(String[] args) {
        int [][] array = {{1,2,3}, {4,5,6}, {7,8,9}};
        System.out.println(Arrays.toString(Snail.snail(array)));
        int [][] array2 = {{1,2,3}, {8,9,4}, {7,6,5}};
        System.out.println(Arrays.toString(Snail.snail(array2)));
    }
}
