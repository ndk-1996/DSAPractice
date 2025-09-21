package com.ndk.dsapractice.leetcode;

// Problem link - https://leetcode.com/problems/merge-intervals/description/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MergeIntervals {

    private static class Interval {
        int left;
        int right;

        public Interval(int left, int right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            arr[i][0] = Integer.parseInt(input[0]);
            arr[i][1] = Integer.parseInt(input[1]);
        }

        System.out.println(Arrays.deepToString(merge(arr)));
    }

    public static int[][] merge(int[][] intervals) {
        List<Interval> intervalList = new ArrayList<>();
        for (int[] interval : intervals) {
            intervalList.add(new Interval(interval[0], interval[1]));
        }

        intervalList.sort(getComparator());

        List<Interval> mergedIntervalsList = new ArrayList<>();
        Interval currInterval = intervalList.getFirst();
        for (int i = 1; i < intervals.length; i++) {
            if (intervalList.get(i).left <= currInterval.right) {
                currInterval.right = Math.max(currInterval.right, intervalList.get(i).right);
            } else {
                mergedIntervalsList.add(new Interval(currInterval.left, currInterval.right));

                currInterval.left = intervalList.get(i).left;
                currInterval.right = intervalList.get(i).right;
            }
        }
        mergedIntervalsList.add(new Interval(currInterval.left, currInterval.right));

        int[][] mergedIntervals = new int[mergedIntervalsList.size()][2];
        for (int i = 0; i < mergedIntervalsList.size(); i++) {
            mergedIntervals[i][0] = mergedIntervalsList.get(i).left;
            mergedIntervals[i][1] = mergedIntervalsList.get(i).right;
        }

        return mergedIntervals;
    }

    private static Comparator<Interval> getComparator() {
        return new Comparator<>() {
            @Override
            public int compare(Interval interval1, Interval interval2) {
                if (interval1.left - interval2.left == 0) {
                    return interval1.right - interval2.right;
                } else {
                    return interval1.left - interval2.left;
                }
            }
        };
    }
}
