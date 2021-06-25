import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=401 lang=java
 *
 * [401] 二进制手表
 */

// @lc code=start
class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if(Integer.bitCount(i) + Integer.bitCount(j) == turnedOn){
                    res.add(i + ":"+ (j<10 ? "0":"") + j);
                }
            }
        }
        return res;
    }
}
// @lc code=end

