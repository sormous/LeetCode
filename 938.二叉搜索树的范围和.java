/*
 * @lc app=leetcode.cn id=938 lang=java
 *
 * [938] 二叉搜索树的范围和
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
    public int rangeSumBST(TreeNode root, int low, int high) {
        return getSum(root, low, high);
    }
    //申明一个方法，返回求和值，首先判断当前节点值和左右范围值大小
    public int getSum(TreeNode root, int low, int high){
        if(root == null) return 0;
        if(root.val > high){
            return getSum(root.left, low, high);
        }else if(root.val < low){
            return getSum(root.right, low, high);
        }else{
            int left = 0, right = 0;
            left = getSum(root.left, low, high);
            right = getSum(root.right, low, high);
            return root.val + left + right;
        }
    }
}
// @lc code=end

