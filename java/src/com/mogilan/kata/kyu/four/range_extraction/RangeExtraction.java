package com.mogilan.kata.kyu.four.range_extraction;

/*A format for expressing an ordered list of integers is to use a comma separated list of either

- individual integers
- or a range of integers denoted by the starting integer separated from
the end integer in the range by a dash, '-'. The range includes all integers
in the interval including both endpoints. It is not considered a range unless
it spans at least 3 numbers. For example "12,13,15-17"
Complete the solution so that it takes a list of integers in increasing order and returns a correctly formatted string in the range format.

Example:

Solution.rangeExtraction(new int[] {-10, -9, -8, -6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20})
# returns "-10--8,-6,-3-1,3-5,7-11,14,15,17-20"
Courtesy of rosettacode.org
*/

public class RangeExtraction {
    public static String rangeExtraction(int[] arr) {
        StringBuilder result = new StringBuilder();
        if (arr == null || arr.length == 0) {
            return "";
        } else {
            result.append(String.valueOf(arr[0]));
            int currentIndex = 1;
            int currentRangeLength = 0;
            while (currentIndex < arr.length) {
                if (arr[currentIndex] == arr[currentIndex - 1] + 1) {
                    currentRangeLength++;
                    if (currentIndex == arr.length - 1) {
                        if (currentRangeLength >= 2) {
                            result.append(String.format("-%d", arr[currentIndex++]));
                        } else if (currentRangeLength == 1) {
                            result.append(String.format(",%d", arr[currentIndex++]));
                        }
                    } else {
                        currentIndex++;
                    }
                } else {
                    if(currentRangeLength >= 2) {
                        result.append(String.format("-%d,%d", arr[currentIndex - 1], arr[currentIndex++]));
                    } else if (currentRangeLength == 1) {
                        result.append(String.format(",%d,%d", arr[currentIndex - 1], arr[currentIndex++]));
                    } else {
                        result.append(String.format(",%d", arr[currentIndex++]));
                    }
                    currentRangeLength = 0;
                }
            }
        }
        return result.toString();
    }
}
