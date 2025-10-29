package com.ndk.dsapractice.gfg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LargestOddNumberInString {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();

        System.out.println(maxOdd(input));
    }

    private static String maxOdd(String s) {
        int pos = -1;
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) - '0') % 2 == 1) {
                pos = i;
            }
        }

        if (pos != -1) {
            return s.substring(0, pos + 1);
        } else {
            return "";
        }
    }
}
