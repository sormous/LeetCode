import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1011 lang=java
 *
 * [1011] 在 D 天内送达包裹的能力
 */

// @lc code=start
class Solution {
    /**
     * 利用二分查找的思想，当运载能力为x，恰好可以在D天完成运输，
     * 那么就有当x'>x时，所需天数<=D;若x'<x，那么所需天数>D
     * @param weights
     * @param D
     * @return
     */
    public int shipWithinDays(int[] weights, int D) {
        //左边界为所有元素中最大值，右边界为所有元素和
        int left = Arrays.stream(weights).max().getAsInt();
        int right = Arrays.stream(weights).sum();

        while(left < right){
            int mid = left + (right-left)/2;
            int need = 1, cur = 0;
            for (int weight : weights) {
                if(cur + weight > mid){
                    need++;
                    cur = 0;
                }
                cur += weight;
            }
            if(need > D){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return left;
    }
}
// @lc code=end

