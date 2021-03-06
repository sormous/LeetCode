/*
 * @lc app=leetcode.cn id=744 lang=java
 *
 * [744] 寻找比目标字母大的最小字母
 */

// @lc code=start
/**
 * 利用二分查找法，找到第一个大于目标字母的字符
 */
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int l=0, r=letters.length-1;
        int m = 0;
        while(l<=r){
            m = l+(r-l)/2;
            //判断条件必须设为中间值<=m目标值
            if(letters[m] <= target){
                l = m+1;
            }
            else{
                r = m-1;
            }
        }
        //如果l满足在数组的下标范围内，则返回满足大于目标值的字母
        return l<letters.length ? letters[l]:letters[0];
    }
}
// @lc code=end

