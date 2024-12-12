package com.ndk.dsapractice.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Problem1800B {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(bufferedReader.readLine());
        while (testCases > 0) {
            String[] s = bufferedReader.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            String input = bufferedReader.readLine();

            Map<Character, Integer> letterCount = new HashMap<>();
            for (int i = 0; i < n; i++) {
                char ch = input.charAt(i);
                if (letterCount.get(ch) == null) {
                    letterCount.put(ch, 1);
                } else {
                    letterCount.put(ch, letterCount.get(ch) + 1);
                }
            }

            int ans = 0;
            for (char c = 'a'; c <= 'z'; c++) {
                int lowerCnt = 0, upperCnt = 0, minCnt, maxCnt, extra;
                if (letterCount.get(c) != null) {
                    lowerCnt = letterCount.get(c);
                }
                if (letterCount.get(Character.toUpperCase(c)) != null) {
                    upperCnt = letterCount.get(Character.toUpperCase(c));
                }

                minCnt = Math.min(lowerCnt, upperCnt);
                maxCnt = Math.max(lowerCnt, upperCnt);
                ans = ans + minCnt;
                extra = (maxCnt - minCnt) / 2;

                if (k > 0 && k > extra) {
                    k = k - extra;
                    ans = ans + extra;
                } else {
                    ans = ans + k;
                    k = 0;
                }
            }

            System.out.println(ans);
            testCases--;
        }
    }
}