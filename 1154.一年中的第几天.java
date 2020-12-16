/*
 * @lc app=leetcode.cn id=1154 lang=java
 *
 * [1154] 一年中的第几天
 */

// @lc code=start
class Solution {
    public int dayOfYear(String date) {
        //首先初始化一个数组，记录每一个月份的天数
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int ans = 0;
        //按照“-”分割字符串
        String[] y_m_d = date.split("-");
        //取出其中的年份元素
        int year = Integer.valueOf(y_m_d[0]);
        //若当前年份为闰年，则将记录数组中的二月天数变为29天
        if(judgeYear(year)) days[1] = 29;
        //取出月份元素
        int month = Integer.valueOf(y_m_d[1]);
        //将该月份之前的天数遍历叠加
        for (int i = 0; i < month-1; i++) {
            ans += days[i];
        }
        //最后加上当天日期的天数
        int day = Integer.valueOf(y_m_d[2]);
        ans += day;
        return ans;
    }
    //定义一个方法判断年份是否为闰年
    private boolean judgeYear(int year){
        if(year % 4 != 0){
            return false;
        }else{
            if(year % 100 != 0){
                return true;
            }else{
                if(year % 400 == 0){
                    return true;
                }else{
                    return false;
                }
            }
        }
    }
}
// @lc code=end

