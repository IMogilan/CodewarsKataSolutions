package com.mogilan.kata.kyu.four.reverse_number;

import java.math.BigInteger;

public class Palindrome {

    // _______________________________________________________________________________________________
    // BEST OPTION: A COMPLEX but FAST solution
    private static long currentPosition = 1L;

    public static BigInteger findReverseNumber(long n) {
        long entryN = n;
        long currentPosition = 1L;
        String currentNumber = "0";
        StringBuilder currentNumberBuilder = new StringBuilder(currentNumber);
        while (n / 10 != 0) {
            if(currentPosition >= 100) {
                currentNumberBuilder.deleteCharAt(currentNumberBuilder.length() - 1);
                currentNumberBuilder.append("00");
                currentNumberBuilder.append("9");
            } else if (currentPosition == 10) {
                currentNumberBuilder = new StringBuilder("909");
            } else {
                currentNumberBuilder = new StringBuilder("9");
            }
            currentPosition *= 10;
            n /= 10;
        }
        currentNumber = currentNumberBuilder.toString();
        while (currentPosition < entryN) {
            currentNumber = findNextReverse(currentNumber, (entryN - currentPosition) > 10);
            currentPosition++;
            System.out.println("Pos " + currentPosition + " Nom " + currentNumber);
        }
        return new BigInteger(currentNumber, 10);
    }

        private static String findNextReverse(String prevNumber, boolean isLostMoreThan10) {
        String result = prevNumber;
        char[] prevNumberChars = prevNumber.toCharArray();
        int length = prevNumberChars.length;
        if (length % 2 == 1) {
            int centerIndex = length / 2;
            int centerValue = Character.getNumericValue(prevNumberChars[centerIndex]);
            if (centerValue < 9) {
                if (centerValue == 0 && isLostMoreThan10) {
                    incrementNumberOnIndex(prevNumberChars, centerIndex, 9);
                    currentPosition += 8L;
                } else {
                    incrementNumberOnIndex(prevNumberChars, centerIndex, 1);
                }
                return String.valueOf(prevNumberChars);
            } else if (length > 1) {
                setZeroOnIndex(prevNumberChars, centerIndex);
                int leftValueIndex = centerIndex - 1;
                int leftValue = Character.getNumericValue(prevNumberChars[leftValueIndex]);
                int rightValueIndex = centerIndex + 1;
                while (leftValueIndex >= 0) {
                    if (leftValue != 9) {
                        incrementNumberOnIndex(prevNumberChars, leftValueIndex, 1);
                        incrementNumberOnIndex(prevNumberChars, rightValueIndex, 1);
                        return String.valueOf(prevNumberChars);
                    } else if (leftValueIndex == 0) {
                        return addTwoAndGetString(prevNumber);
                    } else {
                        setZeroOnIndex(prevNumberChars, leftValueIndex--);
                        setZeroOnIndex(prevNumberChars, rightValueIndex++);
                        leftValue = Character.getNumericValue(prevNumberChars[leftValueIndex]);
                    }
                }
            } else {
                result = String.valueOf(11);
            }
        } else {
            int firstCenterIndex = length / 2 - 1;
            int secondCenterIndex = length / 2;
            int firstCenterValue = Character.getNumericValue(prevNumberChars[firstCenterIndex]);
            if (firstCenterValue < 9) {
                if (firstCenterValue == 0 && isLostMoreThan10) {
                    incrementNumberOnIndex(prevNumberChars, firstCenterIndex, 9);
                    incrementNumberOnIndex(prevNumberChars, secondCenterIndex, 9);
                    currentPosition += 8L;
                } else {
                    incrementNumberOnIndex(prevNumberChars, firstCenterIndex, 1);
                    incrementNumberOnIndex(prevNumberChars, secondCenterIndex, 1);
                }
                return String.valueOf(prevNumberChars);
            } else if (length > 2) {
                setZeroOnIndex(prevNumberChars, firstCenterIndex);
                setZeroOnIndex(prevNumberChars, secondCenterIndex);
                int leftValueIndex = firstCenterIndex - 1;
                int leftValue = Character.getNumericValue(prevNumberChars[leftValueIndex]);
                int rightValueIndex = secondCenterIndex + 1;
                while (leftValueIndex >= 0) {
                    if (leftValue != 9) {
                        incrementNumberOnIndex(prevNumberChars, leftValueIndex, 1);
                        incrementNumberOnIndex(prevNumberChars, rightValueIndex, 1);
                        return String.valueOf(prevNumberChars);
                    } else if (leftValueIndex == 0) {
                        return addTwoAndGetString(prevNumber);
                    } else {
                        prevNumberChars[leftValueIndex--] = Character.forDigit(0, 10);
                        prevNumberChars[rightValueIndex++] = Character.forDigit(0, 10);
                        leftValue = Character.getNumericValue(prevNumberChars[leftValueIndex]);
                    }
                }
            } else {
                result = String.valueOf(101);
            }
        }
        return result;
    }

    private static void setZeroOnIndex(char[] number, int index) {
        number[index] = Character.forDigit(0, 10);
    }

    private static void incrementNumberOnIndex(char[] number, int index, int addendum) {
        number[index] = (char) (number[index] + addendum);
    }

    private static String addTwoAndGetString(String prevNumber) {
        StringBuilder stringBuilder = new StringBuilder(prevNumber.length() + 1);
        stringBuilder.append("1");
        for (int i = 1; i < stringBuilder.capacity() - 1; i++) {
            stringBuilder.append("0");
        }
        stringBuilder.append("1");
        return stringBuilder.toString();
    }
    }
// _______________________________________________________________________________________________



//    private static long getReverse(long number) {
//        long result = 0;
//        while (number != 0) {
//            result = result * 10 + number % 10;
//            number /= 10;
//        }
//        return result;
//    }
//
//    private static BigInteger getNthReverseNumber(long nthPosition) {
//        long currentPosition = 0L;
//        long result = 0L;
//        long currentNumber = 0L;
//        while (currentPosition != nthPosition) {
//            long reverseNumber = getReverse(currentNumber);
//            if (currentNumber == reverseNumber) {
//                System.out.println("Pos: " + currentPosition + "   Nom:" + currentNumber);
//                result = currentNumber;
//                currentPosition++;
//            }
//            currentNumber++;
//        }
//        return BigInteger.valueOf(result);
//    }
//}
//
//    private static BigInteger getReverseNumber(long position) {
//        long currentPosition = 0L;
//        long result = 0L;
//        long currentNumber = 0L;
//        while (currentPosition != position) {
//            long copyOfCurrent = currentNumber;
//            long reverseNumberOfCurrent = 0L;
//            long partOfCurrent = 0L;
//            int i = 0;
//            do {
//                reverseNumberOfCurrent = reverseNumberOfCurrent * 10L + copyOfCurrent % 10;
//                copyOfCurrent = copyOfCurrent / 10;
//            } while (copyOfCurrent % 10 > 0  || copyOfCurrent / 10 > 0);
//            if (currentNumber == reverseNumberOfCurrent) {
//                System.out.println("Pos: " + currentPosition + "   Nom:" + currentNumber);
//                result = currentNumber;
//                currentPosition++;
//            }
//            currentNumber++;
//        }
//        return BigInteger.valueOf(result);
//    }

//
//}
//
////    private static long gerReverseValue (long currentNumber) {
////        long reverseNumberOfCurrent = 0L;
////        int i = 0;
////        do  {
////            reverseNumberOfCurrent += currentNumber % 10 * Math.pow(10, i++);
////            currentNumber = currentNumber / 10;
////        } while (currentNumber / 10 > 0);
////        return reverseNumberOfCurrent;
////    }
////}
//
////

//    Option 1

//    private static BigInteger getReverseNumber(long position) {
//        long result = 0;
//        long currentPosition = 0;
//        long currentNumber = 0;
//        while (currentPosition != position) {
//            if (isReverseNumber(currentNumber)) {
//                currentPosition++;
//                result = currentNumber;
//                System.out.println(currentNumber);
//            }
//            currentNumber++;
//        }
//        return BigInteger.valueOf(result);
//    }
//    private static boolean isReverseNumber(long number) {
//        String numberToString = String.valueOf(number);
//        int i = 0;
//        int j = numberToString.length() - 1;
//        do {
//            if (numberToString.charAt(i++) != numberToString.charAt(j--)){
//                return false;
//            }
//        }  while (i < j);
//        return true;
//    }
//}

//    Option 1
//    private static boolean isReverseNumber(long currentNumber) {
//        boolean result = false;
//        String straight = String.valueOf(currentNumber);
//        while
//        String reverse = new StringBuilder(straight).reverse().toString();
//        return straight.equals(reverse);
//    }
//}

//    Option 2
//    private static boolean isReverseNumber (long currentNumber) {
//        String straight = String.valueOf(currentNumber);
//        int length = straight.length();
//        for (int i = 0; i < length / 2; i++) {
//            if(straight.charAt(i) != straight.charAt(length - 1 - i)) {
//                return false;
//            }
//        }
//        return true;
//    }
//}
