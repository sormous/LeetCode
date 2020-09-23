/*
 * @lc app=leetcode.cn id=492 lang=java
 *
 * [492] 构造矩形
 */

// @lc code=start
class Solution {
    public int[] constructRectangle(int area) {
        int[] res = new int[2];
        //从开方值开始遍历
        int l = (int)Math.sqrt((double)area);
        for (int i = l; i > 0; i--) {
            //得到第一个余数为0的值后，得到所需答案
            if(area % i == 0){
                //长为res/i
                res[0] = area/i;
                //宽为i
                res[1] = i;
                break;
            }
        }
        return res;
    }
}
// @lc code=end

