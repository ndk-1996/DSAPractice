package com.ndk.dsapractice.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1741D {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(bufferedReader.readLine());
        while (testCases > 0) {
            int m = Integer.parseInt(bufferedReader.readLine());
            String[] s = bufferedReader.readLine().split(" ");

            int[] perm = new int[m];
            for (int i = 0; i < m; i++) {
                perm[i] = Integer.parseInt(s[i]);
            }

            int ans = solve(perm, 0, m - 1);
            System.out.println(ans);

            testCases--;
        }
    }

    private static int solve(int[] perm, int start, int end) {
        if (start == end) {
            return 0;
        }

        int mid = (start + end) / 2;

        int leftArrAns = solve(perm, start, mid);
        if (leftArrAns == -1) {
            return -1;
        }

        int rightArrAns = solve(perm, mid + 1, end);
        if (rightArrAns == -1) {
            return -1;
        }

        for (int i = start; i < mid; i++) {
            if (perm[i + 1] - perm[i] != 1) {
                return -1;
            }
        }

        for (int i = mid + 1; i < end; i++) {
            if (perm[i + 1] - perm[i] != 1) {
                return -1;
            }
        }

        int ans = -1;
        if (perm[mid + 1] - perm[mid] == 1) {
            ans = leftArrAns + rightArrAns;
        } else if (perm[start] - perm[end] == 1) {
            int temp, j = start;
            for (int i = mid + 1; i <= end; i++) {
                temp = perm[i];
                perm[i] = perm[j];
                perm[j] = temp;
                j++;
            }
            ans = leftArrAns + rightArrAns + 1;
        }

        return ans;
    }
}