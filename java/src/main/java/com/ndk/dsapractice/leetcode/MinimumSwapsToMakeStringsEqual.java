package com.ndk.dsapractice.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinimumSwapsToMakeStringsEqual {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = bufferedReader.readLine();
        String s2 = bufferedReader.readLine();

        System.out.println(minimumSwap(s1, s2));
    }

    public static int minimumSwap(String s1, String s2) {
        int n = s1.length();

        int countXY = 0;
        int countYX = 0;
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) == 'x' && s2.charAt(i) == 'y') {
                countXY++;
            }

            if (s1.charAt(i) == 'y' && s2.charAt(i) == 'x') {
                countYX++;
            }
        }

        int ans;
        boolean isXYLeft = false;
        boolean isYXLeft = false;
        if (countXY % 2 != 0) {
            isXYLeft = true;
        }

        if (countYX % 2 != 0) {
            isYXLeft = true;
        }

        if (isXYLeft && isYXLeft) {
            ans = countXY / 2 + countYX / 2 + 2;
        } else if (!isXYLeft && !isYXLeft) {
            ans = countXY / 2 + countYX / 2;
        } else {
            ans = -1;
        }

        return ans;
    }
}
