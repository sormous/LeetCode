import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
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
    private Map<Integer, Integer> indexMap;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTree(inorder, postorder, 0, n-1, 0, n-1);
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, int inorder_left, int inorder_right, int postorder_left, int postorder_right){
        if(inorder_left > inorder_right) return null;
        int postorder_root = postorder_right;
        int inorder_root = indexMap.get(postorder[postorder_root]);

        TreeNode root = new TreeNode(postorder[postorder_root]);

        int subleft_size = inorder_root - inorder_left;

        root.left = buildTree(inorder, postorder, inorder_left, inorder_root-1, postorder_left, postorder_left+subleft_size-1);
        root.right = buildTree(inorder, postorder, inorder_root+1, inorder_right, postorder_left+subleft_size, postorder_right-1);

        return root;
    }
}
// @lc code=end

