package com.mogilan.kata.kyu.four.sum_of_intervals;

/* https://www.codewars.com/kata/52b7ed099cdc285c300001cd/train/java
Write a function called sumIntervals/sum_intervals() that accepts an array of intervals, and returns the sum of all the interval lengths. Overlapping intervals should only be counted once.

Intervals
Intervals are represented by a pair of integers in the form of an array. The first value of the interval will always be less than the second value. Interval example: [1, 5] is an interval from 1 to 5. The length of this interval is 4.

Overlapping Intervals
List containing overlapping intervals:

[
   [1,4],
   [7, 10],
   [3, 5]
]
The sum of the lengths of these intervals is 7. Since [1, 4] and [3, 5] overlap, we can treat the interval as [1, 5], which has a length of 4.

Examples:
sumIntervals( [
   [1,2],
   [6, 10],
   [11, 15]
] ) => 9

sumIntervals( [
   [1,4],
   [7, 10],
   [3, 5]
] ) => 7

sumIntervals( [
   [1,5],
   [10, 20],
   [1, 6],
   [16, 19],
   [5, 11]
] ) => 19

sumIntervals( [
   [0, 20],
   [-100000000, 10],
   [30, 40]
] ) => 100000030
Tests with large intervals
Your algorithm should be able to handle large intervals. All tested intervals are subsets of the range [-1000000000, 1000000000].*/

public class Interval {
    public static int sumIntervals(int[][] intervals) {
        int result = 0;
        for (int i = 0; i < intervals.length; i++)
            newCurrent:{
                int[] currentInterval = intervals[i];
                if (currentInterval == null) {
                    break newCurrent;
                }
                int firstOfCurrent = currentInterval[0];
                int lastOfCurrent = currentInterval[1];

                for (int j = i + 1; j < intervals.length; j++)
                    newNext:{
                        int[] nextInterval = intervals[j];
                        if (nextInterval == null) {
                            break newNext;
                        }
                        int firstOfNext = nextInterval[0];
                        int lastOfNext = nextInterval[1];

                        if ((firstOfCurrent >= firstOfNext) && (firstOfCurrent <= lastOfNext)) {
                            if (lastOfCurrent - firstOfCurrent <= lastOfNext - firstOfCurrent) {
                                break newCurrent;
                            } else {
                                nextInterval[1] = firstOfCurrent;
                            }
                        }
                        if ((lastOfCurrent >= firstOfNext) && (lastOfCurrent <= lastOfNext)) {
                            nextInterval[0] = lastOfCurrent;
                        }

                        if (firstOfCurrent <= firstOfNext && lastOfCurrent >= lastOfNext) {
                            intervals[j] = null;
                        }
                    }
                result += lastOfCurrent - firstOfCurrent;
            }
        return result;
    }
}
