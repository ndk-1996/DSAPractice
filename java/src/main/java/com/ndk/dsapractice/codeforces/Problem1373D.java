package com.ndk.dsapractice.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Problem1373D {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(bufferedReader.readLine());
        while (testCases > 0) {
            int n = Integer.parseInt(bufferedReader.readLine());
            String[] s = bufferedReader.readLine().split(" ");
            int[] arr = new int[n];
            long sum = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(s[i]);
                if (i % 2 == 0) {
                    sum = sum + arr[i];
                }
            }

            ArrayList<Integer> oddStartIndexArrList = new ArrayList<>();
            ArrayList<Integer> evenStartIndexArrList = new ArrayList<>();
            for (int i = 0; i < n - 1 ; i++) {
                if (i % 2 == 0) {
                    evenStartIndexArrList.add(arr[i + 1] - arr[i]);
                } else {
                    oddStartIndexArrList.add(arr[i] - arr[i + 1]);
                }
            }

            long maxSumSubArrEven = -1, maxSumSubArrOdd = -1;
            if (!evenStartIndexArrList.isEmpty()) {
                maxSumSubArrEven = findMaxSumSubArr(evenStartIndexArrList);
            }
            if (!oddStartIndexArrList.isEmpty()) {
                maxSumSubArrOdd = findMaxSumSubArr(oddStartIndexArrList);
            }

            long maxSumSubArr = Math.max(maxSumSubArrEven, maxSumSubArrOdd);
            long ans = Math.max(sum, sum + maxSumSubArr);

            System.out.println(ans);

            testCases--;
        }
    }

    private static long findMaxSumSubArr(ArrayList<Integer> arrayList) {
        long maxEndingSum = arrayList.getFirst();
        long maxSum = arrayList.getFirst();
        for (int i = 1; i < arrayList.size(); i++) {
            maxEndingSum = Math.max(maxEndingSum + arrayList.get(i), arrayList.get(i));
            maxSum = Math.max(maxSum, maxEndingSum);
        }

        return maxSum;
    }
}