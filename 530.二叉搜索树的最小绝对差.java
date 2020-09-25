/*
 * @lc app=leetcode.cn id=530 lang=java
 *
 * [530] 二叉搜索树的最小绝对差
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
 * 二叉查找树中，中间节点的值一定是其左右节点值的中间数，
 * 因此最小差别一定是在中间节点与左右节点之间中序遍历二叉查找树，
 * 每次比较当前节点与前一节点差值的绝对值与目前result中保存的最小值的大小，
 * 将较小的保存在result中
 */
class Solution {
    int res = Integer.MAX_VALUE;
    TreeNode preNode = null;
    public int getMinimumDifference(TreeNode root) {
        getMin(root);
        return res;
    }

    private void getMin(TreeNode root){
        if(root == null) return ;
        getMin(root.left);
        if(preNode != null){
            res = Math.min(res, root.val-preNode.val);
        }
        preNode = root;
        getMin(root.right);
    }
}
// @lc code=end

