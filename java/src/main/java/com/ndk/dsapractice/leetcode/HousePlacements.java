package com.ndk.dsapractice.leetcode;

// Problem link - https://leetcode.com/problems/count-number-of-ways-to-place-houses/description/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HousePlacements {

    private static final int mod = (int) (Math.pow(10, 9) + 7);

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        System.out.println(countHousePlacements(n));
    }

    public static int countHousePlacements(int n) {
        long[][] ans = new long[n][2];
        ans[0][0] = 1;
        ans[0][1] = 1;
        for (int i = 1; i < n; i++) {
            ans[i][0] = (ans[i - 1][0] % mod + ans[i - 1][1] % mod) % mod;
            ans[i][1] = ans[i - 1][0];
        }
        long noOfWaysForOneSide = (ans[n - 1][0] + ans[n - 1][1]) % mod;
        long finAns = (noOfWaysForOneSide * noOfWaysForOneSide) % mod;

        return (int) finAns;
    }
}
