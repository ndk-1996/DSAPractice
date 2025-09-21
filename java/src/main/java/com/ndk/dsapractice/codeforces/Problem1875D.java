package com.ndk.dsapractice.codeforces;

// Problem link - https://codeforces.com/contest/1875/problem/D

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem1875D {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(bufferedReader.readLine());

        while (testCases > 0) {
            int n = Integer.parseInt(bufferedReader.readLine());
            String[] input = bufferedReader.readLine().split(" ");

            int[] arr = new int[n];
            Map<Integer, Integer> count = new HashMap<>();
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(input[i]);
                count.put(arr[i], count.getOrDefault(arr[i], 0) + 1);
            }
            Arrays.sort(arr);

            int mex = -1;
            if (arr[0] != 0) {
                mex = 0;
            } else {
                for (int i = 0; i < n - 1; i++) {
                    if (arr[i + 1] - arr[i] > 1) {
                        mex = arr[i] + 1;
                        break;
                    }
                }
            }
            if (mex == -1) {
                mex = arr[n - 1] + 1;
            }

            int[] ans = new int[mex + 1];
            ans[mex] = 0;
            for (int i = mex - 1; i >=0; i--) {
                int minVal = Integer.MAX_VALUE;
                for (int j = i + 1; j <= mex; j++) {
                    minVal = Math.min(minVal, ans[j] + (count.get(i) - 1) * j + i);
                }
                ans[i] = minVal;
            }
            System.out.println(ans[0]);

            testCases--;
        }
    }
}
