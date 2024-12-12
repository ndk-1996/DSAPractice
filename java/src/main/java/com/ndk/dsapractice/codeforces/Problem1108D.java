package com.ndk.dsapractice.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1108D {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        String input = bufferedReader.readLine();
        char[] garland = input.toCharArray();

        int minRecolors = 0;
        for (int i = 0; i < n; i++) {
            if (i - 1 >= 0 && garland[i] == garland[i - 1]) {
                checkAndModifyGarland(garland, i, i + 1);
                minRecolors++;
            } else if (i + 1 < n && garland[i] == garland[i + 1]) {
                if (i + 2 < n) {
                    checkAndModifyGarland(garland, i + 1, i + 2);
                } else if (i - 1 >= 0) {
                    checkAndModifyGarland(garland, i, i - 1);
                } else {
                    checkAndModifyGarland(garland, i, i + 1);
                }
                minRecolors++;
            }
        }

        System.out.println(minRecolors);
        System.out.println(garland);
    }

    private static void checkAndModifyGarland(char[] garland, int i, int j) {
        if (garland[i] == 'R' && garland[j] == 'R') {
            garland[i] = 'G';
        } else if (garland[i] == 'R' && garland[j] == 'G') {
            garland[i] = 'B';
        } else if (garland[i] == 'R' && garland[j] == 'B') {
            garland[i] = 'G';
        } else if (garland[i] == 'G' && garland[j] == 'R') {
            garland[i] = 'B';
        } else if (garland[i] == 'G' && garland[j] == 'G') {
            garland[i] = 'B';
        } else if (garland[i] == 'G' && garland[j] == 'B') {
            garland[i] = 'R';
        } else if (garland[i] == 'B' && garland[j] == 'R') {
            garland[i] = 'G';
        } else if (garland[i] == 'B' && garland[j] == 'G') {
            garland[i] = 'R';
        } else if (garland[i] == 'B' && garland[j] == 'B') {
            garland[i] = 'G';
        }
    }
}
