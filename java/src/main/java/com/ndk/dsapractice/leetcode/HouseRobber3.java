package com.ndk.dsapractice.leetcode;

// Problem link - https://leetcode.com/problems/house-robber-iii/description/

import java.util.HashMap;
import java.util.Map;

public class HouseRobber3 {

     public class TreeNode {
         private int val;
         private TreeNode left;
         private TreeNode right;
         public TreeNode() {}
         public TreeNode(int val) { this.val = val; }
         public TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }

    private Map<Integer, Integer> ansCache = new HashMap<>();

     public int rob(TreeNode root) {
         int ans1 = findAns(root, false);
         int ans2 = findAns(root, true);

         return Math.max(ans1, ans2);
     }

    private int findAns(TreeNode root, Boolean isRobbed) {
        if (root == null) {
            return 0;
        } else {
            Integer cachedAns = ansCache.get(root.hashCode() + isRobbed.hashCode());
            if (cachedAns != null) {
                return cachedAns;
            }
        }

        if (isRobbed) {
            int val = findAns(root.left, false) + findAns(root.right, false) + root.val;
            ansCache.put(root.hashCode() + isRobbed.hashCode(), val);
            return val;
        } else {
            int leftVal1 = findAns(root.left, true);
            int leftVal2 = findAns(root.left, false);

            int rightVal1 = findAns(root.right, true);
            int rightVal2 = findAns(root.right, false);

            int case1 = leftVal1 + rightVal1;
            int case2 = leftVal2 + rightVal2;
            int case3 = leftVal2 + rightVal1;
            int case4 = leftVal1 + rightVal2;

            int finalVal = Math.max(Math.max(Math.max(case1, case2), case3), case4);

            ansCache.put(root.hashCode() + isRobbed.hashCode(), finalVal);
            return finalVal;
        }
    }
}
