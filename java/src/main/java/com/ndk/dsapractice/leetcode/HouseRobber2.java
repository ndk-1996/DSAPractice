package com.ndk.dsapractice.leetcode;

// Problem link - https://leetcode.com/problems/house-robber-ii/description/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HouseRobber2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");
        int[] nums = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        if (nums.length > 1) {
            int max1 = rob(nums, 0, nums.length - 1);
            int max2 = rob(nums, 1, nums.length);
            System.out.println(Math.max(max1, max2));
        } else {
            System.out.println(nums[0]);
        }
    }

    public static int rob(int[] nums, int left, int right) {
        int[] ans = new int[nums.length];
        ans[left] = nums[left];
        if (right - left > 1) {
            ans[left + 1] = Math.max(nums[left], nums[left + 1]);
        }
        for (int i = left + 2; i < right; i++) {
            ans[i] = Math.max(nums[i] + ans[i - 2], ans[i - 1]);
        }

        return ans[right - 1];
    }
}
