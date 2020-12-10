/*
 * @lc app=leetcode.cn id=860 lang=java
 *
 * [860] 柠檬水找零
 */

// @lc code=start
class Solution {
    public boolean lemonadeChange(int[] bills) {
        //利用five和ten记录当前拥有的5元和10元的数量
        int five = 0, ten = 0;
        for (int bill : bills) {
            //若顾客付的5元，则直接记录5元数量+1
            if(bill == 5){
                five++;
            }
            //如果顾客付的10元，则判断是否有5元可以找零，有则5元数量减1，10元数量+1
            else if(bill == 10){
                if(five == 0){
                    return false;
                }
                five--;
                ten++;
            }
            //如果顾客付的20元
            //则先判断是否有一张5元和一张10元进行找零
            //若无，则再判断是否有3张5元找零
            else{
                if(five > 0 && ten > 0){
                    five--;
                    ten--;
                }else if(five >= 3){
                    five -= 3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}
// @lc code=end

