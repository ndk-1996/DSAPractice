package com.ndk.dsapractice.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Problem1443C {

    private static class Pair {
        int first;
        int second;

        public Pair(final int first, final int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(bufferedReader.readLine());

        while (testCases > 0) {
            int n = Integer.parseInt(bufferedReader.readLine());
            String[] sa = bufferedReader.readLine().split(" ");
            String[] sb = bufferedReader.readLine().split(" ");

            List<Pair> pairs = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                pairs.add(new Pair(Integer.parseInt(sa[i]), Integer.parseInt(sb[i])));
            }

            pairs.sort(getCustomComparator());

            long[] suffixSum = new long[n + 1];
            suffixSum[n] = 0;
            suffixSum[n - 1] = pairs.get(n - 1).second;
            for (int i = n - 2; i >= 0; i--) {
                suffixSum[i] = suffixSum[i + 1] + pairs.get(i).second;;
            }

            long ans = Long.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                long tempAns = Math.max(pairs.get(i).first, suffixSum[i + 1]);
                ans = Math.min(ans, tempAns);
            }

            ans = Math.min(ans, suffixSum[0]);

            System.out.println(ans);

            testCases--;
        }
    }

    private static Comparator<Pair> getCustomComparator() {

        return new Comparator<>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                if (p1.first != p2.first) {
                    return Integer.compare(p1.first, p2.first);
                } else {
                    return Integer.compare(p1.second, p2.second);
                }
            }
        };
    }
}
