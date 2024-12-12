package com.ndk.dsapractice.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1409C {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(bufferedReader.readLine());
        while (testCases > 0) {
            String[] s = bufferedReader.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int x = Integer.parseInt(s[1]);
            int y = Integer.parseInt(s[2]);

            int minLastEle = Integer.MAX_VALUE;
            int finalDiff = 0, finalFirstEle = 0;
            for (int j = n; j >= 1; j--) {
                for (int i = 1; i < j; i++) {
                    int diff, firstEle, lastEle;
                    int rem = (y - x) % (j - i);
                    if (rem == 0) {
                        diff = (y - x) / (j - i);
                        firstEle = y - (j - 1) * diff;
                        if (firstEle > 0) {
                            lastEle = firstEle + (n - 1) * diff;

                            if (lastEle < minLastEle) {
                                minLastEle = lastEle;
                                finalDiff = diff;
                                finalFirstEle = firstEle;
                            }
                        }
                    }
                }
            }

            for (int i = 1; i <= n; i++) {
                if (i != n) {
                    System.out.print(finalFirstEle + (i - 1) * finalDiff + " ");
                } else {
                    System.out.println(finalFirstEle + (i - 1) * finalDiff);
                }
            }

            testCases--;
        }
    }
}
