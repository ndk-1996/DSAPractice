package com.ndk.dsapractice.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1883C {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(bufferedReader.readLine());
        while (testCases > 0) {
            String[] s = bufferedReader.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);

            s = bufferedReader.readLine().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }

            int ans = 0;
            if (k != 4) {
                boolean divisible = false;
                for (int ele: arr) {
                    if (ele % k == 0) {
                        divisible = true;
                        break;
                    }
                }

                if (!divisible) {
                    ans = findMinOps(arr, k);
                }
            } else {
                int countOf2 = 0;
                for (int ele: arr) {
                    while (countOf2 < 2 && ele % 2 == 0) {
                        countOf2++;
                        ele = ele / 2;
                    }

                    if (countOf2 == 2) {
                        break;
                    }
                }

                if (countOf2 == 1) {
                    ans = 1;
                } else if (countOf2 == 0) {
                    ans = Math.min(2, findMinOps(arr, k));
                }
            }

            System.out.println(ans);

            testCases--;
        }
    }

    private static int findMinOps(int[] arr, int k) {
        int minOps = Integer.MAX_VALUE;
        for (int ele : arr) {
            minOps = Math.min(minOps, k - ele % k);
        }

        return minOps;
    }
}
