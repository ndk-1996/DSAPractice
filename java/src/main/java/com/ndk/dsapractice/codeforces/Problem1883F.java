package com.ndk.dsapractice.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem1883F {

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

            Set<Integer> helperSet = new HashSet<>();
            List<Integer> startPositions = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (!helperSet.contains(arr[i])) {
                    startPositions.add(i);
                }
                helperSet.add(arr[i]);
            }

            helperSet.clear();
            int[] endPositionsPrefixSum = new int[n];
            for (int i = n - 1; i >= 0; i--) {
                if (!helperSet.contains(arr[i])) {
                    endPositionsPrefixSum[i] = 1;
                }
                helperSet.add(arr[i]);
                if (i != n - 1) {
                    endPositionsPrefixSum[i] = endPositionsPrefixSum[i + 1] + endPositionsPrefixSum[i];
                }
            }

            long ans = 0;
            for (int startPosition : startPositions) {
                ans = ans + endPositionsPrefixSum[startPosition];
            }

            System.out.println(ans);

            testCases--;
        }
    }
}
