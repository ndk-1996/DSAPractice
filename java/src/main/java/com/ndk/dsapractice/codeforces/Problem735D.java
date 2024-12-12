package com.ndk.dsapractice.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem735D {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        if (isPrime(n)) {
            System.out.println(1);
        } else {
            if (n % 2 == 0) {
                System.out.println(2);
            } else {
                if (isPrime(n - 2)) {
                    System.out.println(2);
                } else {
                    System.out.println(3);
                }
            }
        }
    }

    private static boolean isPrime(int n) {
        int divisors = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                divisors = divisors + 2;

                if (i == n/i) {
                    divisors--;
                }
            }
        }

        return divisors == 2;
    }
}