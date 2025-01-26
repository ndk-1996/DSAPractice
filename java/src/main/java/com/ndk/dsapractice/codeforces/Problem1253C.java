package com.ndk.dsapractice.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1253C {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int[] arr = new int[n];
        int i = 0;
        while (stringTokenizer.hasMoreTokens()) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
            i++;
        }
        Arrays.sort(arr);

        long[] ans = new long[n + 1];
        long sum = 0;
        ans[0] = 0;
        for (i = 1; i <= n; i++) {
            sum = sum + arr[i - 1];
            if (i - m < 0) {
                ans[i] = sum;
            } else {
                ans[i] = ans[i - m] + sum;
            }
        }

        for (i = 1; i <= n; i++) {
            if (i != n) {
                System.out.print(ans[i] + " ");
            } else {
                System.out.println(ans[i]);
            }
        }
    }
}
