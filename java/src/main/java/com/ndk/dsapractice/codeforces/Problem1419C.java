package com.ndk.dsapractice.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Problem1419C {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(bufferedReader.readLine());
        while (testCases > 0) {
            String[] s = bufferedReader.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int x = Integer.parseInt(s[1]);
            s = bufferedReader.readLine().split(" ");

            Map<Integer, Integer> elementCount = new HashMap<>();
            int sum = 0, ele = 0;
            for (int i = 0; i < n; i++) {
                ele = Integer.parseInt(s[i]);
                if (elementCount.containsKey(ele)) {
                    elementCount.put(ele, elementCount.get(ele) + 1);
                } else {
                    elementCount.put(ele, 1);
                }

                sum = sum + ele;
            }

            if (elementCount.size() == 1 && ele == x) {
                System.out.println(0);
            } else if (elementCount.containsKey(x)) {
                System.out.println(1);
            } else if (sum == n * x) {
                System.out.println(1);
            } else {
                System.out.println(2);
            }

            testCases--;
        }
    }
}
