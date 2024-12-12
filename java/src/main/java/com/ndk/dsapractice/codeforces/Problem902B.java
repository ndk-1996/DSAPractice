package com.ndk.dsapractice.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Problem902B {

    private static int ans;
    private static ArrayList<Integer>[] tree;
    private static int[] colorArr;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        String[] s = bufferedReader.readLine().split(" ");

        tree = new ArrayList[n];
        for (int i = 1; i < n; i++) {
            int v = Integer.parseInt(s[i - 1]);
            if (tree[i] == null) {
                tree[i] = new ArrayList<>();
            }
            if (tree[v - 1] == null) {
                tree[v - 1] = new ArrayList<>();
            }
            tree[i].add(v - 1);
            tree[v - 1].add(i);
        }

        s = bufferedReader.readLine().split(" ");

        colorArr = new int[n];
        for (int i = 0; i < n; i++) {
            colorArr[i] = Integer.parseInt(s[i]);
        }

        ans = 1;
        depthFirstSearch(0, -1, colorArr[0]);

        System.out.println(ans);
    }

    private static void depthFirstSearch(int node, int parent, int color) {
        for (int child: tree[node]) {
            if (child != parent) {
                if (colorArr[child] == color) {
                    depthFirstSearch(child, node, color);
                } else {
                    ans++;
                    depthFirstSearch(child, node, colorArr[child]);
                }
            }
        }
    }
}