import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=257 lang=java
 *
 * [257] 二叉树的所有路径
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ret = new ArrayList<>();
        if(root == null) return ret;
        solve(ret, "", root);
        return ret;
    }
    //利用深度优先遍历方法，递归得到每一条路径，前序遍历
    private void solve(List<String> ret, String cur, TreeNode root){
        if(root == null) return;
        cur += root.val;
        //当节点为叶子节点时，将路径加入到列表中
        if(root.left == null && root.right == null){
            ret.add(cur);
        }else{
            solve(ret, cur+"->", root.left);
            solve(ret, cur+"->", root.right);
        }
        
    }
}
// @lc code=end

