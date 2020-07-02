/*
 * @lc app=leetcode.cn id=110 lang=java
 *
 * [110] 平衡二叉树
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
 * 自顶向下来判断该二叉树是否为平衡二叉树！
 * 从根节点出发，判断其左右子树的高度，
 * 满足条件则继续判断根节点的左右子树分别是否满足平衡树条件！
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true; //首先判断空树特殊情况下
        //再判断左右子树为空的特殊情况
        else if(root.left == null && root.right == null) return true;
        //若左子树树高-右子树树高的绝对值大于1则返回false
        else if(Math.abs(hight(root.left)-hight(root.right)) > 1){
            return false;
        }
        //接着判断左右子树是否为平衡树？
        else{
            return isBalanced(root.left)&&isBalanced(root.right);
        }
    }

    //求树高
    private int hight(TreeNode root){
        if(root == null) return 0;
        int l = hight(root.left);
        int r = hight(root.right);
        return l > r ? l+1:r+1; 
    }
}
// @lc code=end

