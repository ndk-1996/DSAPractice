package com.ndk.dsapractice.leetcode;

// Problem link - https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingChars {

    public static void main(String[] s) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();

        System.out.println(lengthOfLongestSubstring(input));
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastPosOfChar = new HashMap<>();
        int ans = 0;
        int i = 0, j = 0;
        while (j < s.length()) {
            System.out.println("i = " + i + ", j = " + j);
            Integer lastPos = lastPosOfChar.get(s.charAt(j));
            if (lastPos != null) {
                ans = Math.max(ans, j - i);
                for (int k = i; k <= lastPos; k++) {
                    lastPosOfChar.remove(s.charAt(k));
                }
                i = lastPos + 1;
            }

            lastPosOfChar.put(s.charAt(j), j);
            j++;
        }
        ans = Math.max(ans, j - i);

        return ans;
    }
}
