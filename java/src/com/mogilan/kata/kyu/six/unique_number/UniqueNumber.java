package com.mogilan.kata.kyu.six.unique_number;

public class UniqueNumber {

    public static double findUniq(double arr[]) {
        int indexOfUnique = 0;
        boolean isUniqFound = false;
        double firstValue = arr[0];
        double lastValue = arr[arr.length - 1];
        if (firstValue != lastValue) {
            if (firstValue == arr[1]) {
                indexOfUnique = arr.length - 1;
                isUniqFound = true;
            } else {
                indexOfUnique = 0;
                isUniqFound = true;
            }
        }
        int currentIndex = 0;
        while (!isUniqFound && ++currentIndex < arr.length - 1) {
            isUniqFound = (arr[currentIndex - 1] != arr[currentIndex]);
            if (isUniqFound) {
                indexOfUnique = currentIndex;
            }
        }
        return arr[indexOfUnique];
    }
}
