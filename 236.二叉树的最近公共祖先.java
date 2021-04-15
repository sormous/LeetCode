import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=236 lang=java
 *
 * [236] 二叉树的最近公共祖先
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
    //因为题设中，Node.val互不相同，所以利用它来作为键值即可<Node.val, parentNode>
    Map<Integer, TreeNode> parent = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //首先利用自定义函数dfs，记录所有的节点和其父节点
        dfs(root);
        //然后开始遍历p节点，向上寻找其所有父节点，直至根节点，存储到visited集合中
        while(p != null){
            visited.add(p.val);
            p = parent.get(p.val);
        }

        //然后开始遍历q节点的父节点，若在集合中存在相同的父节点，那么直接返回
        while(q != null){
            if(visited.contains(q.val)){
                return q;
            }
            q = parent.get(q.val);
        }
        return null;
    }

    //利用dfs，通过map记录当前节点的值和其父节点
    private void dfs(TreeNode root){
        if(root.left != null){
            parent.put(root.left.val, root);
            dfs(root.left);
        }
        if(root.right != null){
            parent.put(root.right.val, root);
            dfs(root.right);
        }
        
    }
}
// @lc code=end

