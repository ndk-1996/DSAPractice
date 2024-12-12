package com.ndk.dsapractice.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem832A {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bufferedReader.readLine().split(" ");
        long n = Long.parseLong(s[0]);
        long k = Long.parseLong(s[1]);
        long nMoves = n / k;

        if (nMoves % 2 == 1) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}