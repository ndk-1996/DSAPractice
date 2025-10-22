package com.ndk.dsapractice.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1594C {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(bufferedReader.readLine());

        while (testCases > 0) {
            String[] nAndC = bufferedReader.readLine().split(" ");
            int n = Integer.parseInt(nAndC[0]);
            char c = nAndC[1].charAt(0);
            String s = bufferedReader.readLine();

            boolean allEq = true;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) != c) {
                    allEq = false;
                    break;
                }
            }

            if (allEq) {
                System.out.println(0);
            } else {
                int x = 2;
                boolean allMultiplesEq = true;
                for (int i = 2; i <= n; i++) {
                    allMultiplesEq = true;
                    for (int j = i; j <= n; j = j + i) {
                        if (s.charAt(j - 1) != c) {
                            allMultiplesEq = false;
                            break;
                        }
                    }
                    if (allMultiplesEq) {
                        x = i;
                        break;
                    }
                }

                if (allMultiplesEq) {
                    System.out.println(1);
                    System.out.println(x);
                } else {
                    System.out.println(2);
                    System.out.println(n + " " +  (n - 1));
                }
            }

            testCases--;
        }
    }
}
