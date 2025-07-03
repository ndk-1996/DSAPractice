package com.ndk.dsapractice.leetcode;

// Problem link - https://leetcode.com/problems/3sum/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ThreeSum {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");

        int[] arr = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        System.out.println(threeSum(arr));
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> triplets = new HashSet<>();

        for (int k = 0; k < nums.length; k++) {
            Set<Integer> twoSumEle = new HashSet<>();
            for (int j = 0; j < k; j++) {
                int ele = -1 * (nums[j] + nums[k]);
                if (twoSumEle.contains(ele)) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(ele);
                    triplet.add(nums[j]);
                    triplet.add(nums[k]);
                    triplet.sort(Comparator.naturalOrder());
                    triplets.add(triplet);
                }

                twoSumEle.add(nums[j]);
            }
        }

        return new ArrayList<>(triplets);
    }
}
