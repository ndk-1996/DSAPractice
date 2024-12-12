package com.ndk.dsapractice.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1741E {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(bufferedReader.readLine());
        while (testCases > 0) {
            int n = Integer.parseInt(bufferedReader.readLine());
            String[] s = bufferedReader.readLine().split(" ");

            int[] brr = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                brr[i] = Integer.parseInt(s[i - 1]);
            }

            boolean[] ans = new boolean[n + 1];
            ans[0] = true;
            for (int i = 1; i <= n; i++) {
                if (ans[i - 1] && i + brr[i] <= n) {
                    ans[i + brr[i]] = true;
                }

                if (i - brr[i] - 1 >= 0 && ans[i - brr[i] - 1]) {
                    ans[i] = true;
                }
            }

            if (ans[n]) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }

            testCases--;
        }
    }
}