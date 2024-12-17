package com.ndk.dsapractice.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1856B {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(bufferedReader.readLine());
        while (testCases > 0) {
            int n = Integer.parseInt(bufferedReader.readLine());
            String[] s = bufferedReader.readLine().split(" ");
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }

            if (n == 1) {
                System.out.println("No");
            } else {
                int countOfOne = 0;
                long sum = 0;
                for (int i = 0; i < n; i++) {
                    sum = sum + arr[i];
                    if (arr[i] == 1) {
                        countOfOne++;
                    }
                }

                if (sum - n >= countOfOne) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }
            testCases--;
        }
    }
}
