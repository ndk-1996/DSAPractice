package com.ndk.dsapractice.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem451B {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        String[] s = bufferedReader.readLine().split(" ");

        int[] arr = new int[n];
        int i;
        for (i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        int l = 0, r = n - 1, segments = 0;
        boolean segStarted = false;
        for (i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1] && !segStarted) {
                l = i;
                segStarted = true;
            }

            if (arr[i] < arr[i + 1] && segStarted) {
                r = i;
                segStarted = false;
                segments++;
            }

            if (segments > 1) {
                break;
            }
        }

        if (segStarted) {
            r = n - 1;
            segStarted = false;
            segments++;
        }

        if (segments == 0) {
            System.out.println("yes");
            System.out.println(1 + " " + 1);
        } else if (segments == 1) {
            if (l - 1 >= 0 && r + 1 < n) {
                if (arr[l - 1] < arr[r] && arr[l] < arr[r + 1]) {
                    l++;
                    r++;
                    System.out.println("yes");
                    System.out.println(l + " " + r);
                } else {
                    System.out.println("no");
                }
            } else if (l - 1 < 0 && r + 1 < n) {
                if (arr[l] < arr[r + 1]) {
                    l++;
                    r++;
                    System.out.println("yes");
                    System.out.println(l + " " + r);
                } else {
                    System.out.println("no");
                }
            } else if (l - 1 >= 0 && r + 1 >= n) {
                if (arr[l - 1] < arr[r]) {
                    l++;
                    r++;
                    System.out.println("yes");
                    System.out.println(l + " " + r);
                } else {
                    System.out.println("no");
                }
            } else if (l - 1 < 0 && r + 1 >= n) {
                l++;
                r++;
                System.out.println("yes");
                System.out.println(l + " " + r);
            }
        } else {
            System.out.println("no");
        }
    }
}