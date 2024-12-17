package com.ndk.dsapractice.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1288C {

    private static final int mod = (int) (Math.pow(10, 9) + 7);

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        long[][] ansA = new long[m + 1][n + 1];
        long[][] ansB = new long[m + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            ansA[1][i] = 1;
            ansB[1][i] = 1;
        }
        for (int i = 2; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                ansA[i][j] = 0;
                for (int k = 1; k <= j; k++) {
                    ansA[i][j] = (ansA[i][j] + ansA[i - 1][k]) % mod;
                }
            }
        }

        for (int i = 2; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                ansB[i][j] = 0;
                for (int k = j; k <= n; k++) {
                    ansB[i][j] = (ansB[i][j] + ansB[i - 1][k]) % mod;
                }
            }
        }

        long finAns = 0;
        for (int i = 1; i <= n; i++) {
            long sum = 0;
            for (int j = i; j <= n; j++) {
                sum = (sum + ansB[m][j]) % mod;
            }
            finAns = (finAns + (sum * ansA[m][i]) % mod) % mod;
        }

        System.out.println(finAns);
    }
}
