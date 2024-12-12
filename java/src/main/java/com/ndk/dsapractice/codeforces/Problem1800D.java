package com.ndk.dsapractice.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1800D {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(bufferedReader.readLine());
        while (testCases > 0) {
            int n = Integer.parseInt(bufferedReader.readLine());
            String input = bufferedReader.readLine();

            int ans = n - 1;
            for (int i = 0; i < n - 2; i++) {
                if (input.charAt(i) == input.charAt(i + 2)) {
                    ans--;
                }
            }

            System.out.println(ans);
            testCases--;
        }
    }
}