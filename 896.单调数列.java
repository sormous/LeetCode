/*
 * @lc app=leetcode.cn id=896 lang=java
 *
 * [896] 单调数列
 */

// @lc code=start
class Solution {
    public boolean isMonotonic(int[] A) {
        //长度为0时，返回false
        if(A.length == 0) return false;
        //长度小于等于2时，返回true
        if(A.length <= 2) return true;
        //利用一个tag表示该数组为递增还是递减，1表示递增，0表示递减
        int tag = -1;
        int cur = A[1];
        //先判断前两个数，看是否有递增性或是递减性
        if(cur > A[0]) tag = 1;
        else if(cur < A[0]) tag = 0;
        //然后从第三个数开始进行遍历比较
        for (int i = 2; i < A.length; i++) {
            //若前面的数字未判断出单调性，则需要先判断单调性
            if(tag == -1){
                if(A[i] > cur) tag = 1;
                else if(A[i] < cur) tag = 0;
            }
            //有单调性后，判断当前数字是否满足当前的单调性
            else{
                if((tag == 1 && A[i] < cur)||(tag == 0 && A[i] > cur)){
                    return false;
                }
                //然后对cur赋值，方便后续判断
                cur = A[i];
            }
        }
        return true;
    }
}
// @lc code=end

