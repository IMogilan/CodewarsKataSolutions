package com.mogilan.kata.kyu.five.count_ip_addresses;

/* https://www.codewars.com/kata/526989a41034285187000de4

Count IP Addresses

Implement a function that receives two IPv4 addresses, and returns the number of addresses between them (including the first one, excluding the last one).

All inputs will be valid IPv4 addresses in the form of strings. The last address will always be greater than the first one.

Examples
* With input "10.0.0.0", "10.0.0.50"  => return   50
* With input "10.0.0.0", "10.0.1.0"   => return  256
* With input "20.0.0.10", "20.0.1.0"  => return  246
*/

public class CountIPAddresses {

    public static long ipsBetween(String start, String end) {
        String[] startIp = start.split("\\.");
        String[] endIp = end.split("\\.");

        long[] difference = new long[4];
        for (int i = 0; i < 4; i++) {
            difference[i] = Long.parseLong(startIp[i]) - Long.parseLong(endIp[i]);
        }

        long result = 0;
        long coefficient = 3;
        for (long i : difference) {
            result += i * Math.pow(256, coefficient--);
        }

        return Math.abs(result);
    }

}
