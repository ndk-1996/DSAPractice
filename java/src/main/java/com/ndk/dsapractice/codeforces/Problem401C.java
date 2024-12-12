package com.ndk.dsapractice.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem401C {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        if (n == m) {
            System.out.println(getAns(m, n));
        } else if (n - 1 == m) {
            System.out.println(getAns(m, n));
        } else if (m % 2 == 0) {
            if (n >= m / 2 - 1 && n <= m - 1) {
                System.out.println(getAns(m, n));
            } else {
                System.out.println(-1);
            }
        } else {
            if (n >= m / 2 && n <= m - 1) {
                System.out.println(getAns(m, n));
            } else {
                System.out.println(-1);
            }
        }
    }

    private static StringBuilder getAns(int m, int n) {
        StringBuilder res = new StringBuilder();

        if (m == n) {
            while (n > 0) {
                res.append("10");
                n--;
                m--;
            }
        } else if (m == n - 1) {
            while (m > 0) {
                res.append("01");
                n--;
                m--;
            }
            res.append("0");
            n--;
        }
        else {
            while (m > 0 && n > 0 && m - 1 != n ) {
                res.append("110");
                m = m - 2;
                n = n - 1;
            }
            while (n > 0) {
                res.append("10");
                n--;
                m--;
            }

            for (int i = 0; i < m; i++) {
                res.append('1');
            }
        }

        return res;
    }
}