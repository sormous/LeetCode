import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=872 lang=java
 *
 * [872] 叶子相似的树
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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafs1 = new ArrayList<>();
        List<Integer> leafs2 = new ArrayList<>();
        leafs1 = Pre(root1, leafs1);
        leafs2 = Pre(root2, leafs2);
        //然后判断两棵树的叶子节点列表是否相同
        if(leafs1.size() != leafs2.size()){
            return false;
        }else{
            for (int i = 0; i < leafs1.size(); i++) {
                if(leafs1.get(i) != leafs2.get(i)){
                    return false;
                }
            }
        }
        return true;
    }

    //利用先序遍历得到叶子节点的列表
    private List<Integer> Pre(TreeNode root, List<Integer> leafs){
        if(root.left == null && root.right == null){
            leafs.add(root.val);
        }
        if(root.left != null) Pre(root.left, leafs);
        if(root.right != null) Pre(root.right, leafs);
        return leafs;
    }
}
// @lc code=end

