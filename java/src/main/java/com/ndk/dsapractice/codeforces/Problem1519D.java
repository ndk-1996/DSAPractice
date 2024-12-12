package com.ndk.dsapractice.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1519D {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        String[] s = bufferedReader.readLine().split(" ");
        long[] arr = new long[n];
        int i, j;
        for (i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        s = bufferedReader.readLine().split(" ");
        long[] brr = new long[n];
        for (i = 0; i < n; i++) {
            brr[i] = Integer.parseInt(s[i]);
        }

        long[][] rev = new long[n][n];
        long[] left = new long[n];
        long[] right = new long[n];

        i = 0; j = n - 1;
        left[0] = arr[0] * brr[0];
        right[n - 1] = arr[n - 1] * brr[n - 1];
        i++; j--;
        while (i < n && j >= 0) {
            left[i] = left[i - 1] + arr[i] * brr[i];
            right[j] = right[j + 1] + arr[j] * brr[j];

            i++; j--;
        }

        long ans = -1;
        long tempAns;
        for (i = n - 1; i >= 0; i--) {
            for (j = i; j < n; j++) {
                if (i == j) {
                    rev[i][j] = arr[i] * brr[i];
                } else if (i - j == 1) {
                    rev[i][j] = arr[i] * brr[j] + arr[j] * brr[i];
                } else {
                    rev[i][j] = rev[i + 1][j - 1] + arr[i] * brr[j] + arr[j] * brr[i];
                }

                if (i - 1 < 0 && j + 1 > n - 1) {
                    tempAns = rev[i][j];
                } else if (i - 1 < 0) {
                    tempAns = rev[i][j] + right[j + 1];
                } else if (j + 1 > n - 1) {
                    tempAns = left[i - 1] + rev[i][j];
                } else {
                    tempAns = left[i - 1] + rev[i][j] + right[j + 1];
                }

                ans = Math.max(ans, tempAns);
            }
        }

        System.out.println(ans);
    }
}