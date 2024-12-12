package com.ndk.dsapractice.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1941C {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(bufferedReader.readLine());

        while (testCases > 0) {
            int n = Integer.parseInt(bufferedReader.readLine());
            String s = bufferedReader.readLine();

            int ans = 0, i = 0;
            while (i < n - 2) {
                if (i + 3 < n
                        && i + 4 < n
                        && s.charAt(i) == 'm'
                        && s.charAt(i + 1) == 'a'
                        && s.charAt(i + 2) == 'p'
                        && s.charAt(i + 3) == 'i'
                        && s.charAt(i + 4) == 'e'
                ) {
                    ans++;
                    i = i + 5;
                }

                else if (s.charAt(i) == 'm' && s.charAt(i + 1) == 'a' && s.charAt(i + 2) == 'p') {
                    ans++;
                    i = i + 3;
                }

                else if (s.charAt(i) == 'p' && s.charAt(i + 1) == 'i' && s.charAt(i + 2) == 'e') {
                    ans++;
                    i = i + 3;
                }

                else {
                    i++;
                }
            }

            System.out.println(ans);
            testCases--;
        }
    }
}