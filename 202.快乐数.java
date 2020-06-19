import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=202 lang=java
 *
 * [202] 快乐数
 */

// @lc code=start
class Solution {
    /**
     * 利用一个HashMap存储出现过的数字
     * 若在后续计算中再次出现这个数字，则说明存在循环，都不可能计算得到1
     * 那么这个数也就不是快乐数
     * 
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        while(n != 1){
            int temp = 0;
            while(n != 0){
                temp += Math.pow(n%10, 2);
                n /= 10;
            }
            if(map.containsKey(temp)){
                return false;
            }
            else{
                map.put(temp, 1);
            }
            n = temp;
        }
        return true;
    }
}
// @lc code=end

