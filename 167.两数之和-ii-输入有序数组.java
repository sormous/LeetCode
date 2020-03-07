/*
 * @lc app=leetcode.cn id=167 lang=java
 *
 * [167] 两数之和 II - 输入有序数组
 */

// @lc code=start
class Solution {
    //如果数组很大，target很小，可以考虑先用二分查找法找到不大于target元素的下标，再作处理
    public int[] twoSum(int[] numbers, int target) {
        //        int idx = search(numbers, target);
                int idx = numbers.length - 1;
                return twoSum(numbers, target, idx);
            }
        
            public int[] twoSum(int[] numbers, int target, int end) {
                int[] result = {0, 0};
        
                int lo = 0;
                int hi = end;
                //从开头和结尾两个方向开始，进行搜索
                while (lo < hi) {
                    if (numbers[lo] + numbers[hi] == target) {
                        result[0] = lo+1;
                        result[1] = hi+1;
                        break;
                    } else if (numbers[lo] + numbers[hi] > target) {
                        hi--;
                    } else {
                        lo++;
                    }
                }
        
                return result;
            }
        
            public int search(int[] numbers, int target) {
        
                int lo = 0;
                int hi = numbers.length - 1;
                int mid;
        
                while (lo <= hi) {
                    mid = lo + (hi - lo) / 2;
                    if (numbers[mid] == target) {
                        return mid;
                    } else if (numbers[mid] > target) {
                        hi = mid - 1;
                    } else {
                        lo = mid + 1;
                    }
        
                }
                return hi;
            }
    
    
    // public int[] twoSum(int[] numbers, int target) {
    //     int[] ans ={0, 0};
    //     int temp=0;
    //     int len = numbers.length;
    //     for(int i=0; i<len; i++){
    //         temp = target - numbers[i];
    //         if(temp < numbers[i]){
    //             continue;
    //         }
    //         else{
    //             for(int j=i+1; j<len; j++){
    //                 if(temp == numbers[j]){
    //                     ans[0] = i+1;
    //                     ans[1] = j+1;
    //                 }
    //                 if(temp < numbers[j]){
    //                     break;
    //                 }
    //             }
    //         }
    //     }
    //     return ans;
    // }
}
// @lc code=end

