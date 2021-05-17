/*
 * @lc app=leetcode.cn id=993 lang=java
 *
 * [993] 二叉树的堂兄弟节点
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
    TreeNode xParent = null;
    TreeNode yParent = null;
    int xDepth;
    int yDepth;
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, 0, x, y, null);
        return xDepth == yDepth && xParent != yParent;
    }

    public void dfs(TreeNode root, int depth, int x, int y, TreeNode parent){
        if(root == null){
            return;
        }
        if(root.val == x){
            xDepth = depth;
            xParent = parent;
        }
        if(root.val == y){
            yDepth = depth;
            yParent = parent;
        }

        dfs(root.left, depth+1, x, y, root);
        dfs(root.right, depth+1, x, y, root);
    }
}
// @lc code=end

