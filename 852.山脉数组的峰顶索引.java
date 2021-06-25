/*
 * @lc app=leetcode.cn id=852 lang=java
 *
 * [852] 山脉数组的峰顶索引
 */

// @lc code=start
class Solution {
    /**
     * 利用二分思想，知道找到满足arr[m]既大于左边又大于右边的数
     * @param arr
     * @return
     */
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int l = 0, r = n-1;
        int m = 0;
        while(l < r){
            m = l+(r-l)/2;
            int a = m-1, b = m+1;
            if(arr[a] < arr[m] && arr[m] > arr[b]){
                break;
            }
            else if(arr[a] < arr[m] && arr[b] > arr[m]){
                l = m;
            }else{
                r = m;
            }
        }
        return m;
    }
}
// @lc code=end

