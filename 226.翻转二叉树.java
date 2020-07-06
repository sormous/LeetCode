/*
 * @lc app=leetcode.cn id=226 lang=java
 *
 * [226] 翻转二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * 可以利用先序遍历的思想，自顶向下开始交换
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        //保存右子树
        TreeNode rTree = root.right;
        //交换左右子树的位置
        root.right = invertTree(root.left);
        root.left = invertTree(rTree);
        return root;
    }
}
// @lc code=end

