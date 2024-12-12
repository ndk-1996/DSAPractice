package com.ndk.dsapractice.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem877C {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int m = n + n / 2;
        int even = 0;

        System.out.println(m);
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                even++;
                System.out.print(i + " ");
            }
        }
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1) {
                System.out.print(i + " ");
            }
        }
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                cnt++;
                if (cnt < even) {
                    System.out.print(i + " ");
                } else {
                    System.out.print(i);
                }
            }
        }
    }
}