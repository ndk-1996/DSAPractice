package com.ndk.dsapractice.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1741C {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(bufferedReader.readLine());
        while (testCases > 0) {
            int n = Integer.parseInt(bufferedReader.readLine());
            String[] s = bufferedReader.readLine().split(" ");

            int[] arr = new int[n];
            for (int i = 0; i < n; i ++) {
                arr[i] = Integer.parseInt(s[i]);
            }

            int sum = 0, tempSum;
            int segStartIndex;
            int maxThicknessOfCurrentSplit, ans = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                sum = sum + arr[i];
                maxThicknessOfCurrentSplit = Integer.MIN_VALUE;
                segStartIndex = i + 1;
                tempSum = 0;
                for (int j = i + 1; j < n; j++) {
                    if (tempSum < sum) {
                        tempSum = tempSum + arr[j];
                    } else if (tempSum > sum) {
                        break;
                    }

                    if (tempSum == sum) {
                        maxThicknessOfCurrentSplit = Math.max(maxThicknessOfCurrentSplit, j - segStartIndex + 1);
                        segStartIndex = j + 1;
                        tempSum = 0;
                    }
                }

                if (tempSum != 0) {
                    maxThicknessOfCurrentSplit = Integer.MIN_VALUE;
                }

                if (i == n - 1) {
                    maxThicknessOfCurrentSplit = Math.max(maxThicknessOfCurrentSplit, i + 1);
                }

                if (maxThicknessOfCurrentSplit != Integer.MIN_VALUE) {
                    maxThicknessOfCurrentSplit = Math.max(maxThicknessOfCurrentSplit, i + 1);
                    ans = Math.min(ans, maxThicknessOfCurrentSplit);
                }
            }

            System.out.println(ans);

            testCases--;
        }
    }
}
