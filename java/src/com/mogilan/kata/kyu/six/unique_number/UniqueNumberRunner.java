package com.mogilan.kata.kyu.six.unique_number;

/*Find the unique number
There is an array with some numbers. All numbers are equal except for one. Try to find it!

Kata.findUniq(new double[]{ 1, 1, 1, 2, 1, 1 }); // => 2
Kata.findUniq(new double[]{ 0, 0, 0.55, 0, 0 }); // => 0.55
It’s guaranteed that array contains at least 3 numbers.

The tests contain some very huge arrays, so think about performance.

This is the first kata in series:

Find the unique number (this kata)
Find the unique string
Find The Unique
 */

public class UniqueNumberRunner {
    public static void main(String[] args) {
        double uniq = UniqueNumber.findUniq(new double[]{1, 23, 1, 1, 1, 1});
        double uniq2 = UniqueNumber.findUniq(new double[]{ 0, 4, 0, 0, 0 });
        System.out.println(uniq);
        System.out.println(uniq2);
    }
}
