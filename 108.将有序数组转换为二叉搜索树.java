/*
 * @lc app=leetcode.cn id=108 lang=java
 *
 * [108] 将有序数组转换为二叉搜索树
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
 * 可以看作中序遍历的逆过程！该题对于每个数组的解并不是唯一解！
 * 区间分治类，使用左右都闭合的区间进行计算，
 * 每次取排序数组中的中间值作为当前根节点，小的放左子树，大的放右子树
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        //左右等分建立左右子树，中间节点作为数根节点，递归该过程
        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int l, int r){
        if(l > r){
            return null;
        }
        int m = l + (r - l)/2; //可防止溢出
        TreeNode root = new TreeNode(nums[m]);
        root.left = buildTree(nums, l, m-1);
        root.right = buildTree(nums, m+1, r);
        return root;
    }
}
// @lc code=end

