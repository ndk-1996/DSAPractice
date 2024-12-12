package com.ndk.dsapractice.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1151C {

    private static final int modulo = (int) (Math.pow(10, 9) + 7);

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bufferedReader.readLine().split(" ");
        long l = Long.parseLong(s[0]);
        long r = Long.parseLong(s[1]);

        long ans = (calcSum(r) - calcSum(l - 1) + modulo) % modulo;

        System.out.println(ans);
    }

    private static long calcSum(long n) {
        long evenNums = 0, oddNums = 0, nums = 1;
        int stage = 0;
        while (n > 0) {
            if (n >= nums) {
                n = n - nums;

                if (stage % 2 == 0) {
                    oddNums = oddNums + nums;
                } else {
                    evenNums = evenNums + nums;
                }
            } else {
                if (stage % 2 == 0) {
                    oddNums = oddNums + n;
                } else {
                    evenNums = evenNums + n;
                }

                n = 0;
            }

            nums = nums * 2;
            stage++;
        }

        oddNums = oddNums % modulo;
        evenNums = evenNums % modulo;

        return ((evenNums * (evenNums + 1)) % modulo + (oddNums * oddNums) % modulo) % modulo;
    }
}