/*
 * @lc app=leetcode.cn id=504 lang=java
 *
 * [504] 七进制数
 */

// @lc code=start
class Solution {
    public String convertToBase7(int num) {
        //首先判断若num=0，则直接返回“0”字符串
        if(num == 0) return "0";
        //声明一个flag变量，来记录num是否为负数，是否需要添加负号
        boolean flag = true;
        //初始一个res字符串，初始为空
        String res = "";
        //若num<0，则将其变成绝对值，并记录flag
        if(num < 0){
            num = Math.abs(num);
            flag = false;
        }
        //在num大于0时，进行遍历
        while(num > 0){
            //用num对7求余，得到余数字符串
            String s = Integer.toString(num%7);
            //将res字符串添加到余数字符串之后
            res = s.concat(res);
            //更新num
            num = num/7;
        }
        //若初始num为负数，则最后需要添加符号
        if(flag == false) res = "-".concat(res);
        return res;
    }
}
// @lc code=end

