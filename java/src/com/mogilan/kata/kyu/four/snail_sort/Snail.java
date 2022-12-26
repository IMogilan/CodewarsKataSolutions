package com.mogilan.kata.kyu.four.snail_sort;

/*Snail Sort
Given an n x n array, return the array elements arranged from outermost elements to the middle element, traveling clockwise.

array = [[1,2,3],
         [4,5,6],
         [7,8,9]]
snail(array) #=> [1,2,3,6,9,8,7,4,5]
For better understanding, please follow the numbers of the next array consecutively:

array = [[1,2,3],
         [8,9,4],
         [7,6,5]]
snail(array) #=> [1,2,3,4,5,6,7,8,9]
This image will illustrate things more clearly:


NOTE: The idea is not sort the elements from the lowest value to the highest; the idea is to traverse the 2-d array in a clockwise snailshell pattern.

NOTE 2: The 0x0 (empty matrix) is represented as en empty array inside an array [[]].*/

public class Snail {

    public static int[] snail(int[][] array) {
       if(array == null || array.length == 0 || array[0].length == 0) {
           return new int[]{};
       }
       int [] result = new int[array.length * array[0].length];
       int column = 0, raw = 0;
       int loopNumber = 0;
       int currentIndexOfResult = 0;
       while (currentIndexOfResult != result.length) {
           for (; column < array[raw].length - loopNumber; column++) {
               result[currentIndexOfResult++] = array[raw][column];
               if (currentIndexOfResult == result.length) {
                   break;
               }
           }
           column--;
           raw++;
           for (; raw < array.length - loopNumber; raw++) {
               result[currentIndexOfResult++] = array[raw][column];
               if (currentIndexOfResult == result.length) {
                   break;
               }
           }
           raw--;
           column--;
           for (; column >= loopNumber; column--) {
               result[currentIndexOfResult++] = array[raw][column];
               if (currentIndexOfResult == result.length) {
                   break;
               }
           }
           column++;
           raw--;
           for (; raw >= loopNumber + 1; raw--) {
               result[currentIndexOfResult++] = array[raw][column];
               if (currentIndexOfResult == result.length) {
                   break;
               }
           }
           raw++;
           column++;
           loopNumber++;
       }
       return result;
    }
}
