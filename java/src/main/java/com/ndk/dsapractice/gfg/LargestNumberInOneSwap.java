package com.ndk.dsapractice.gfg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LargestNumberInOneSwap {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();

        System.out.println(largestSwap(input));
    }

    private static String largestSwap(String s) {
        int maxTillNow = -1;
        int left = -1;
        int right = -1;
        int maxTillNowPos = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (maxTillNow > s.charAt(i) - '0') {
                left = i;
                right = maxTillNowPos;
            }

            if (s.charAt(i) - '0' > maxTillNow) {
                maxTillNow = s.charAt(i) - '0';
                maxTillNowPos = i;
            }
        }

        if (left != -1) {
            char[] output = s.toCharArray();
            char temp = output[left];
            output[left] = output[right];
            output[right] = temp;

            return new String(output);
        } else {
            return s;
        }
    }
}
