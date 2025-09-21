package com.ndk.dsapractice.leetcode;

// Problem link - https://leetcode.com/problems/put-marbles-in-bags/description/

// TODO: Try DP solution as well for practice purpose.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PutMarblesInBag {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");
        int k = Integer.parseInt(bufferedReader.readLine());

        int[] arr = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        System.out.println(putMarbles(arr, k));
    }

    private static long putMarbles(int[] weights, int k) {
        if (k - 1 == 0) {
            return 0;
        }

        PriorityQueue<Integer> maxScores = new PriorityQueue<>(k - 1); // MinHeap
        PriorityQueue<Integer> minScores = new PriorityQueue<>(k - 1, Comparator.reverseOrder()); // MaxHeap

        for (int i = 0; i < weights.length - 1; i++) {
            if (maxScores.size() < k - 1) {
                maxScores.add(weights[i] + weights[i + 1]);
            } else if (maxScores.size() == k - 1) {
                if (weights[i] + weights[i + 1] > maxScores.peek()) {
                    maxScores.poll();
                    maxScores.add(weights[i] + weights[i + 1]);
                }
            }

            if (minScores.size() < k - 1) {
                minScores.add(weights[i] + weights[i + 1]);
            } else if (minScores.size() == k - 1) {
                if (weights[i] + weights[i + 1] < minScores.peek()) {
                    minScores.poll();
                    minScores.add(weights[i] + weights[i + 1]);
                }
            }
        }

        long max = 0, min = 0;
        for (Integer value: maxScores) {
            max = max + value;
        }
        for (Integer value: minScores) {
            min = min + value;
        }

        return max - min;
    }
}
