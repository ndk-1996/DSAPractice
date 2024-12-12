package com.ndk.dsapractice.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Problem1729D {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine());
        while (t > 0) {
            int n = Integer.parseInt(bufferedReader.readLine());
            String[] sx = bufferedReader.readLine().split(" ");
            String[] sy = bufferedReader.readLine().split(" ");
            ArrayList<Integer> negative_arr = new ArrayList<>();
            TreeMap<Integer, Integer> positive_map = new TreeMap<>();

            int x, y, diff;
            Integer val;
            for (int i = 0; i < n; i++) {
                x = Integer.parseInt(sx[i]);
                y = Integer.parseInt(sy[i]);
                diff = y - x;
                if (diff < 0) {
                    negative_arr.add(diff);
                } else {
                    val = positive_map.get(diff);
                    if (val != null) {
                        positive_map.put(diff, val + 1);
                    } else {
                        positive_map.put(diff, 1);
                    }
                }
            }

            Collections.sort(negative_arr);
            Integer key;
            int ans = 0;
            for (int ele: negative_arr) {
                ele = Math.abs(ele);
                key = positive_map.ceilingKey(ele);
                if (key != null) {
                    ans++;
                    val = positive_map.get(key);
                    if (val - 1 == 0) {
                        positive_map.remove(key);
                    } else {
                        positive_map.put(key, val - 1);
                    }
                }
            }

            int size = 0;
            for (Map.Entry<Integer, Integer> entry: positive_map.entrySet()) {
                size = size + entry.getValue();
            }

            ans = ans + size / 2;

            System.out.println(ans);
            t--;
        }
    }
}