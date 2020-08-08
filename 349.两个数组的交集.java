import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=349 lang=java
 *
 * [349] 两个数组的交集
 */

// @lc code=start
/**
 * 利用集合的特性来存储相同的元素值，得到交集
 * 最后将set转换成int数组即可
 */
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s = new HashSet<Integer>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for(int i=0, j=0; i<nums1.length && j<nums2.length;){
            if(nums1[i] == nums2[j]){
                s.add(nums1[i]);
                i++;
                j++;
            }else if(nums1[i] < nums2[j]){
                i++;
            }else{
                j++;
            }
        }
        Integer[] temp = s.toArray(new Integer[]{});
        int[] ans = new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            ans[i] = temp[i].intValue();
        }
        return ans;
    }
}
// @lc code=end

