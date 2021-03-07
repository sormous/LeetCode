/*
 * @lc app=leetcode.cn id=605 lang=java
 *
 * [605] 种花问题
 */

// @lc code=start
/**
 * 利用贪心算法思想，遍历flowered数组，每当遍历到为0且其左右都为0时
 * 表示该位置可以种花，然后将该位置置1，接着遍历数组
 */
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            //如果当前位置没有种花，那么判断其左右是否有种花？
            if(flowerbed[i] == 0 && (i==0 || flowerbed[i-1] ==0) && (i==flowerbed.length-1 || flowerbed[i+1] == 0)){
                //然后将该位置置1，表示成功种花
                flowerbed[i] = 1;
                count++;
            }
        }
        return count >= n;
    }
}
// @lc code=end

