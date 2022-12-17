package com.mogilan.kata.kyu.four.sum_of_intervals;

public class IntervalRunner {
    public static void main(String[] args) {
        int firstCheck = Interval.sumIntervals(new int[][]{{1, 2}, {6, 10}, {11, 15}});
        System.out.println(firstCheck);
        int secondCheck = Interval.sumIntervals(new int[][]{{1, 4}, {7, 10}, {3, 5}});
        System.out.println(secondCheck);
        int thirdCheck = Interval.sumIntervals(new int[][]{{1, 5}, {10, 20}, {1, 6}, {16, 19}, {5, 11}});
        System.out.println(thirdCheck);
        int fourthCheck = Interval.sumIntervals(new int[][]{{0, 20}, {-100000000, 10}, {30, 40}});
        System.out.println(fourthCheck);

    }
}
