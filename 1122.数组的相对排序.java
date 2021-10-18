
/*
 * @lc app=leetcode.cn id=1122 lang=java
 *
 * [1122] 数组的相对排序
 */

// @lc code=start
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int upper = 0;
        for(int num:arr1){
            if(num > upper){
                upper = num;
            }
        }
        int[] memo = new int[upper+1];
        for(int num:arr1){
            memo[num]++;
        }

        int[] res = new int[arr1.length];
        int cur = 0;
        for(int num:arr2){
            for(int i=0; i<memo[num]; i++){
                res[cur++] = num;
            }
            memo[num] = 0;
        }

        for (int i = 0; i < memo.length; i++) {
            if(memo[i] != 0){
                for (int j = 0; j < memo[i]; j++) {
                    res[cur++] = i;
                }
            }
        }
        return res;

    }
}
// @lc code=end

