package com.ndk.dsapractice.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1937B {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(bufferedReader.readLine());
        while (testCases > 0) {
            int n = Integer.parseInt(bufferedReader.readLine());
            String a = bufferedReader.readLine();
            String b = bufferedReader.readLine();

            StringBuilder c = new StringBuilder();
            c.append(a.charAt(0));
            int noOfPaths = 1;
            boolean hopped = false;
            for (int i = 0; i < n - 1; i++) {
                if (!hopped) {
                    if (b.charAt(i) == a.charAt(i + 1)) {
                        noOfPaths++;
                        c.append(a.charAt(i + 1));
                    } else if (b.charAt(i) == '0' && a.charAt(i + 1) == '1') {
                        c.append(b.charAt(i));
                        hopped = true;
                    } else if (b.charAt(i) == '1' && a.charAt(i + 1) == '0') {
                        c.append(a.charAt(i + 1));
                        noOfPaths = 1;
                    }
                } else {
                    c.append(b.charAt(i));
                }
            }
            c.append(b.charAt(n - 1));

            System.out.println(c);
            System.out.println(noOfPaths);

            testCases--;
        }
    }
}