package com.ndk.dsapractice.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1843C {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(bufferedReader.readLine());

        while (testCases > 0) {
            long n = Long.parseLong(bufferedReader.readLine());
            long ans = 0;

            while (n > 0) {
                ans = ans + n;
                n = n / 2;
            }

            System.out.println(ans);
            testCases--;
        }
    }
}