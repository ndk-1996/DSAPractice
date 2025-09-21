package com.ndk.dsapractice.leetcode;

// Problem link - https://leetcode.com/problems/house-robber/description/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HouseRobber {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");
        int[] nums = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = nums[0];
        if (nums.length > 1) {
            ans[1] = Math.max(nums[0], nums[1]);
        }
        for (int i = 2; i < nums.length; i++) {
            ans[i] = Math.max(nums[i] + ans[i - 2], ans[i - 1]);
        }

        return ans[nums.length - 1];

    }
}
