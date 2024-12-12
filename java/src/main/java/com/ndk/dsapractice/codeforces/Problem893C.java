package com.ndk.dsapractice.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Problem893C {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        s = bufferedReader.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        ArrayList<Integer>[] graph = new ArrayList[n];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < m; i++) {
            String[] pair = bufferedReader.readLine().split(" ");
            int x = Integer.parseInt(pair[0]);
            int y = Integer.parseInt(pair[1]);
            x--;
            y--;

            if (graph[x] == null) {
                graph[x] = new ArrayList<>();
            }
            if (graph[y] == null) {
                graph[y] = new ArrayList<>();
            }

            graph[x].add(y);
            graph[y].add(x);
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                ans = ans + depthFirstSearch(graph, visited, arr, i);
            }
        }


        System.out.println(ans);
    }

    private static int depthFirstSearch(ArrayList<Integer>[] graph, boolean[] visited, int[] arr, int u) {
        visited[u] = true;
        int minGold = arr[u];
        if (graph[u] != null) {
            for (int v: graph[u]) {
                if (!visited[v]) {
                    minGold = Math.min(minGold, depthFirstSearch(graph, visited, arr, v));
                }
            }
        }

        return minGold;
    }
}