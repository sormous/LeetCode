import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=970 lang=java
 *
 * [970] 强整数
 */

// @lc code=start
/**
 * 从两个数的零次方开始循环，每次循环乘以自身，
 * 每次将两数之和放进集合中，避免重复元素，
 * 再者若x,y等于1，则跳出循环，
 * 最后将集合转成列表返回
 */
class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> set = new HashSet<>();
        for(int a=1; a<bound; a*=x){
            for(int b=1; a+b<=bound; b*=y){
                set.add(a+b);
                if(y == 1) break;
            }
            if(x == 1) break;
        }
        return new ArrayList<>(set);
    }
}
// @lc code=end

