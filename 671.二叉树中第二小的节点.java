/*
 * @lc app=leetcode.cn id=671 lang=java
 *
 * [671] 二叉树中第二小的节点
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
 * 最小的值，一定是根节点的值
 */
class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        return getSecondMax(root, root.val);
    }

    private int getSecondMax(TreeNode root, int min){
        //当前节点为叶子节点，无子节点
        if(root == null) return -1;
        //若当前节点值>根节点值，则直接返回该节点值
        if(root.val > min) return root.val;
        //若当前节点值等于跟节点值，那么就去其左右子节点去寻找目标值
        int l = getSecondMax(root.left, min);
        int r = getSecondMax(root.right, min);
        //如果两棵子树均存在大于根节点的值，那么返回较小的一个
        if(l != -1 && r != -1){
            return Math.min(l, r);
        }
        //否则返回较大的一个
        else{
            return Math.max(l, r);
        }
    }
}
// @lc code=end

