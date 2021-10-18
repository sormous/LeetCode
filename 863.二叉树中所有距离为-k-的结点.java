import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=863 lang=java
 *
 * [863] 二叉树中所有距离为 K 的结点
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
  * 思路：从target出发进行dfs，并记录距离即可
  * 此题需要额外将每个节点的父节点记录，以用来记录
  */
class Solution {
    Map<Integer, TreeNode> map = new HashMap<>();
    List<Integer> res = new ArrayList<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        dfs_parents(root);
        dfs(target, null, k, 0);
        return res;
    }

    private void dfs_parents(TreeNode node){
        if(node.left != null){
            map.put(node.left.val, node);
            dfs_parents(node.left);
        }

        if(node.right != null){
            map.put(node.right.val, node);
            dfs_parents(node.right);
        }
    }

    private void dfs(TreeNode node, TreeNode from, int k, int dis){
        if(node == null){
            return ;
        }
        if(dis == k){
            res.add(node.val);
            return ;
        }
        if(node.left != from){
            dfs(node.left, node, k, dis+1);
        }
        if(node.right != from){
            dfs(node.right, node, k, dis+1);
        }
        if(map.get(node.val) != from){
            dfs(map.get(node.val), node, k, dis+1);
        }
    }
}
// @lc code=end

