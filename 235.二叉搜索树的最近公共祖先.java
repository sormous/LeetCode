/*
 * @lc app=leetcode.cn id=235 lang=java
 *
 * [235] 二叉搜索树的最近公共祖先
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
 * 一次遍历二叉搜索树节点，如果两节点都小于当前节点，那么都在当前节点左子树上；
 * 如果两节点都大于当前节点，那么都在当前节点右子树上；
 * 否则，当前节点为分叉节点，即最近公共祖先节点。
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = root;
        while(true){
            if(res.val > p.val && res.val > q.val){
                res = res.left;
            }
            else if(res.val < p.val && res.val < q.val){
                res = res.right;
            }else{
                break;
            }
        }
        return res;
    }
}
// @lc code=end

