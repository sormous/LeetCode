import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=771 lang=java
 *
 * [771] 宝石与石头
 */

// @lc code=start
/**
 * 利用集合存储每一种珠宝，然后遍历stones，没存在一个字符在集合中
 * 则count+1，在石头中存在一个宝石
 */
class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> set = new HashSet<Character>();
        int count = 0;
        for (int i = 0; i < jewels.length(); i++) {
            set.add(jewels.charAt(i));
        }
        for (int i = 0; i < stones.length(); i++) {
            if(set.contains(stones.charAt(i))){
                count++;
            }
        }
        return count;
    }
}
// @lc code=end

