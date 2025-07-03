package com.ndk.dsapractice.leetcode;

// Problem link - https://leetcode.com/problems/longest-nice-subarray/description/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestNiceSubarray {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");

        int[] arr = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        System.out.println(longestNiceSubarray(arr));
    }

    private static int longestNiceSubarray(int[] nums) {


        return 0;
    }
}
