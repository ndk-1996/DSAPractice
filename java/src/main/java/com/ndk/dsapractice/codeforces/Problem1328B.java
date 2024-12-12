package com.ndk.dsapractice.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1328B {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(bufferedReader.readLine());

        while (testCases > 0) {
            String[] s = bufferedReader.readLine().split(" ");
            long n = Integer.parseInt(s[0]);
            long k = Integer.parseInt(s[1]);

            long posOfB1FromLast;
            long j = (long) Math.sqrt(2 * k);
            if (j * (j + 1) < 2 * k) {
                posOfB1FromLast = j + 2;
            } else if (j * (j + 1) == 2 * k) {
                posOfB1FromLast = j + 1;
            } else {
                posOfB1FromLast = j + 1;
                j--;
            }

            long posOfB2FromLast;
            if (k - (j * (j + 1) / 2) == 0) {
                posOfB2FromLast = posOfB1FromLast - 1;
            } else {
                posOfB2FromLast = k - (j * (j + 1) / 2);
            }

            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < n - posOfB1FromLast; i++) {
                ans.append('a');
            }
            ans.append('b');
            for (int i = 0; i < posOfB1FromLast - posOfB2FromLast - 1; i++) {
                ans.append('a');
            }
            ans.append('b');
            for (int i = 0; i < posOfB2FromLast - 1; i++) {
                ans.append('a');
            }

            System.out.println(ans);

            testCases--;
        }
    }
}