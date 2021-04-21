/*
 * @lc app=leetcode.cn id=1360 lang=java
 *
 * [1360] 日期之间隔几天
 */

// @lc code=start
class Solution {
    //初始化一个数组，用来记录每月的天数，若遇到闰年，且包含2月，那么计算时+1
    int[] month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    /**
     * 分别计算两个日期距1970-01-01的天数，然后做差
     * @param date1
     * @param date2
     * @return
     */
    public int daysBetweenDates(String date1, String date2) {
        int year1 = Integer.valueOf(date1.substring(0, 4)), year2 = Integer.valueOf(date2.substring(0, 4));
        int month1 = Integer.valueOf(date1.substring(5, 7)), month2 = Integer.valueOf(date2.substring(5, 7));
        int day1 = Integer.valueOf(date1.substring(8)), day2 = Integer.valueOf(date2.substring(8));

        int count1 = 0, count2 = 0;
        for (int i = 1971; i < year1; i++) {
            if(judgeYear(i)){
                count1 += 366;
            }else{
                count1 += 365;
            }
        }
        for (int i = 0; i < month1-1; i++) {
            count1 += month[i];
            if(i == 1 && judgeYear(year1)){
                count1++;
            }
        }
        count1 += day1;

        for (int i = 1971; i < year2; i++) {
            if(judgeYear(i)){
                count2 += 366;
            }else{
                count2 += 365;
            }
        }
        for (int i = 0; i < month2-1; i++) {
            count2 += month[i];
            if(i == 1 && judgeYear(year2)){
                count2++;
            }
        }
        count2 += day2;

        return Math.abs(count1-count2);
    }

    /**
     * 判断年份是否为闰年
     * 判断条件为：能被4整除且不能被100整除或者能被400整除
     * @param year
     * @return
     */
    private boolean judgeYear(int year){
        if((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)){
            return true;
        }
        return false;
    }
}
// @lc code=end

