import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * @lc app=leetcode.cn id=987 lang=java
 *
 * [987] 二叉树的垂序遍历
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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<int[]> nodes = new ArrayList<>();
        dfs(root, nodes, 0, 0);
        Collections.sort(nodes, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[0] != b[0]){
                    return a[0]-b[0];
                }else if(a[1] != b[1]){
                    return a[1]-b[1];
                }else{
                    return a[2]-b[2];
                }
            }
        });

        int lastCol = Integer.MIN_VALUE, size = 0;
        for (int[] tuple : nodes) {
            int col = tuple[0], raw = tuple[1], value = tuple[2];
            if(col != lastCol){
                lastCol = col;
                res.add(new ArrayList<>());
                size++;
            }
            res.get(size-1).add(value);
        }
        return res;
    }

    private void dfs(TreeNode root, List<int[]> nodes, int col, int raw){
        if(root == null){
            return ;
        }
        nodes.add(new int[]{col, raw, root.val});
        dfs(root.left, nodes, col-1, raw+1);
        dfs(root.right, nodes, col+1, raw+1);
    }
}
// @lc code=end

