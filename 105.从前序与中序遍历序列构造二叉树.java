import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
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
class Solution {
    private Map<Integer, Integer> indexMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        indexMap = new HashMap<>();
        //构造中序遍历的哈希表映射，快速定位到根节点的位置
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        TreeNode root = buildTree(preorder, inorder, 0, n-1, 0, n-1);
        return root;
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right){
        if(preorder_left > preorder_right) return null;
        //先序遍历的第一个就为根节点
        int preorder_root = preorder_left;
        //在中序遍历中得到根节点的位置
        int inorder_root = indexMap.get(preorder[preorder_root]);

        TreeNode root = new TreeNode(preorder[preorder_root]);

        //得到左子树的节点数大小
        int subleft_size = inorder_root - inorder_left;
        //递归构造左子树
        root.left = buildTree(preorder, inorder, preorder_left+1, preorder_left+subleft_size, inorder_left, inorder_root-1);
        //递归构造右子树
        root.right = buildTree(preorder, inorder, preorder_left+subleft_size+1, preorder_right, inorder_root+1, inorder_right);
        return root;
        }
}
// @lc code=end

