package com.ndk.dsapractice.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1245C {

    private static final int m = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        int n = input.length();

        for (int i = 0; i < n; i++) {
            if (input.charAt(i) == 'w' || input.charAt(i) == 'm') {
                System.out.println(0);
                return;
            }
        }

        long[] fibonacci = new long[n + 2];
        fibonacci[1] = 1;
        fibonacci[2] = 2;
        for (int i = 3; i <= n; i++) {
            fibonacci[i] = (fibonacci[i - 1] + fibonacci[i - 2]) % m;
        }

        int countUOrN = 1;
        long ans = 1;
        for (int i = 0; i < n - 1; i++) {
            if (input.charAt(i) == 'u' && input.charAt(i + 1) == 'u') {
                countUOrN++;
            } else if (input.charAt(i) == 'n' && input.charAt(i + 1) == 'n') {
                countUOrN++;
            } else {
                ans = (ans * fibonacci[countUOrN]) % m;
                countUOrN = 1;
            }
        }
        ans = (ans * fibonacci[countUOrN]) % m;

        System.out.println(ans);
    }
}