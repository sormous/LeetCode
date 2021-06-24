import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=149 lang=java
 *
 * [149] 直线上最多的点数
 */

// @lc code=start
class Solution {
    /**
     * 因为经过某一固定点，且斜率相同的点，一定共线
     * @param points
     * @return
     */
    public int maxPoints(int[][] points) {
        int n = points.length;
        //最开始判断如果小于等于2，则直接返回n
        if(n <= 2){
            return n;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            //如果经过该点，共线的节点已经超过n-i或者半数，则直接返回
            if(res >= n-i || res > n/2){
                break;
            }
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = i+1; j < n; j++) {
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];
                if(x == 0){
                    y = 1;
                }else if(y == 0){
                    x = 1;
                }else{
                    if(y < 0){
                        x = -x;
                        y = -y;
                    }
                }
                int gcdXY = gcd(x, y);
                x /= gcdXY;
                y /= gcdXY;
                int k = x*20001 + y;
                map.put(k, map.getOrDefault(k, 0) + 1);
            }
            int maxnum = 0;
            for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                int num = entry.getValue();
                //当前斜率的最大个数，为num+1，得加上本身点
                maxnum = Math.max(maxnum, num+1);
            }
            res = Math.max(res, maxnum);
        }
        return res;
    }
    //计算最大公约数，用作最简化分数
    public int gcd(int x, int y){
        return y == 0 ? x : gcd(y, x%y);
    }
}
// @lc code=end

