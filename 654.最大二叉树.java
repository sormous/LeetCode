/*
 * @lc app=leetcode.cn id=654 lang=java
 *
 * [654] 最大二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length-1);
    }

    private TreeNode build(int[] nums, int l, int r){
        if(l > r){
            return null;
        }

        //寻找出数组中的最大值和位置
        int index = -1, maxValue = Integer.MIN_VALUE;
        for (int i = l; i <= r; i++) {
            if(nums[i] > maxValue){
                maxValue = nums[i];
                index = i;
            }
        }

        TreeNode root = new TreeNode(maxValue);
        //递归调用，构造左右子树
        root.left = build(nums, l, index-1);
        root.right = build(nums, index+1, r);

        return root;
    }
}
// @lc code=end

