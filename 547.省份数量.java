/*
 * @lc app=leetcode.cn id=547 lang=java
 *
 * [547] 省份数量
 */

// @lc code=start
/**
 * 利用深度优先遍历dfs方法，对每个城市进行遍历，找到连通分量的数量，即为省份的数量。
 * 若该城市没有被访问过，则对该城市进行深度优先遍历，找到与该城市连接的所有城市
 */
class Solution {
    public int findCircleNum(int[][] isConnected) {
        //max表示可能存在的最多省份数，即数组的长度
        int max = isConnected.length;
        //visited数组表示某城市是否有访问过
        boolean[] visited = new boolean[max];
        int provinces = 0;
        for (int i = 0; i < max; i++) {
            //首先判断当前城市是否被访问过
            if(!visited[i]){
                dfs(max, i, isConnected, visited);
                //完成上述递归，即表示找到一个连通分量，省份数+1
                provinces++;
            }
        }
        return provinces;
    }

    //深度优先遍历，i表示需要进行的深度优先遍历的城市的指针
    private void dfs(int max, int i, int[][] isConnected, boolean[] visited){
        for (int j = 0; j < max; j++) {
            if(isConnected[i][j] == 1 && !visited[j]){
                visited[j] = true;
                dfs(max, j, isConnected, visited);
            }
        }
    }
}
// @lc code=end

