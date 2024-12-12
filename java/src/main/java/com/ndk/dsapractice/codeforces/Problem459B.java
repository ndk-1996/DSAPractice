package com.ndk.dsapractice.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem459B {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        String[] s = bufferedReader.readLine().split(" ");

        int[] brr = new int[n];
        for (int i = 0; i < n; i++) {
            brr[i] = Integer.parseInt(s[i]);
        }

        int min = brr[0], max = brr[0];
        long cntMin = 0, cntMax = 0;
        for (int i = 1; i < n; i++) {
            if (brr[i] < min) {
                min = brr[i];
            }

            if (brr[i] > max) {
                max = brr[i];
            }
        }

        for (int i = 0; i < n; i++) {
            if (brr[i] == min) {
                cntMin++;
            }

            if (brr[i] == max) {
                cntMax++;
            }
        }

        if (min == max) {
            System.out.println(0 + " " + (cntMax * (cntMax - 1)) / 2);
        } else {
            System.out.println(max - min + " " + cntMax * cntMin);
        }
    }
}