package com.ndk.dsapractice.leetcode;

// Problem link - https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");

        int[] prices = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            prices[i] = Integer.parseInt(input[i]);
        }

        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int maxTillNow = -1;
        int profit = -100000;
        for (int i = prices.length - 1; i >= 0; i--) {
            if (maxTillNow != -1) {
                profit = Math.max(profit, maxTillNow - prices[i]);
            }

            if (prices[i] > maxTillNow) {
                maxTillNow = prices[i];
            }
        }

        return Math.max(profit, 0);
    }
}
