/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] 单词搜索
 */

// @lc code=start
class Solution {
    private int raw;
    private int col;
    
    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public boolean exist(char[][] board, String word) {
        //在String中判值等，用equals；若用==判断，其判断的是地址是否相等
        //System.out.println(new StringBuffer("ABCCED").toString().equals(word));
        if(board == null || board.length == 0 || board[0].length == 0){
            return false;
        }
        raw = board.length;
        col = board[0].length;
        boolean[][] visited = new boolean[raw][col];
        for (int i = 0; i < raw; i++) {
            for (int j = 0; j < col; j++) {
                //方法1
                // StringBuffer s = new StringBuffer();
                // visited = new boolean[raw][col];
                // if(search(visited, board, i, j, s, word)){
                //     return true;
                // }
                
                //方法2
                if(backtracking(0, i, j, board, word, visited)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(boolean[][] visited, char[][] board, int r, int c, StringBuffer s, String word){
        s.append(board[r][c]);
        // System.out.println(Integer.toString(r) + Integer.toString(c) + s.toString());
        visited[r][c] = true;
        if(s.length() == word.length()){
            if(s.toString().equals(word)){
                return true;
            }
            return false;
        }
        for (int[] d : directions) {
            int cr = r+d[0], cc = c+d[1];
            if(cr < 0 || cr >= raw || cc < 0 || cc >= col || visited[cr][cc] == true || s.charAt(s.length()-1) != word.charAt(s.length()-1)){
                continue;
            }
            //System.out.println(Integer.toString(cr)+Integer.toString(cc));
            if(search(visited, board, cr, cc, s, word)) return true;
            visited[cr][cc] = false;
            s.deleteCharAt(s.length()-1);
        }
        return false;
    }

    private boolean backtracking(int curlen, int r, int c, char[][] board, String word, boolean[][] visited){
        if(curlen == word.length()) return true;
        if(r < 0 || r >= raw || c < 0 || c >= col 
                || board[r][c] != word.charAt(curlen) || visited[r][c]){
            return false;
        }

        visited[r][c] = true;

        for (int[] d : directions) {
            if(backtracking(curlen+1, r+d[0], c+d[1], board, word, visited)){
                return true;
            }
        }
        //在该位置节点周围节点遍历完全之后再将该节点置为未访问状态
        visited[r][c] = false;
        
        return false;
    }

}
// @lc code=end

