package com.ndk.dsapractice.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Problem1689C {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine());
        while (t > 0) {
            int n = Integer.parseInt(bufferedReader.readLine());
            ArrayList<Integer>[] tree = new ArrayList[n];
            int[][] ans = new int[n][2];
            for (int i = 0; i < n; i++) {
                tree[i] = new ArrayList<>();
            }
            for (int i = 0; i < n - 1; i++) {
                String[] s = bufferedReader.readLine().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                u--;
                v--;
                tree[u].add(v);
                tree[v].add(u);
            }

            depthFirstSearch(tree, ans, 0, -1);
            System.out.println(ans[0][1]);
            t--;
        }
    }

    private static void depthFirstSearch(ArrayList<Integer>[] tree, int[][] ans, int v, int p) {
        if (tree[v].size() == 1 && tree[v].get(0) == p) {
            ans[v][0] = 1;
            ans[v][1] = 0;
        } else {
            int[] child = new int[2];
            int i = 0;
            for (Integer c: tree[v]) {
                if (c != p) {
                    depthFirstSearch(tree, ans, c, v);
                    child[i] = c;
                    i++;
                }
            }

            if (i == 1) {
                ans[v][0] = ans[child[0]][0] + 1;
                ans[v][1] = ans[child[0]][0] - 1;
            } else if (i == 2) {
                ans[v][0] = ans[child[0]][0] + ans[child[1]][0] + 1;
                ans[v][1] = Math.max(ans[child[0]][0] - 1 + ans[child[1]][1], ans[child[0]][1] + ans[child[1]][0] - 1);
            }
        }
    }
}
