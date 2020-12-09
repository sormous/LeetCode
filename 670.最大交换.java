/*
 * @lc app=leetcode.cn id=670 lang=java
 *
 * [670] 最大交换
 */

// @lc code=start
class Solution {
    public int maximumSwap(int num) {
        if(num == 0) return 0;
        char[] chars = String.valueOf(num).toCharArray();
        int[] maxIndex = new int[chars.length];
        int max = chars.length - 1;
        //寻找最大的数字的下标
        for (int i = chars.length-1; i >= 0; i--) {
            if(chars[i] - '0' > chars[max] - '0'){
                max = i;
            }
            maxIndex[i] = max;
        }
        //正序遍历，找到第一个不是最大的数，将该数和其右边最大的数交换
        for (int i = 0; i < maxIndex.length; i++) {
            int iValue = chars[i] - '0';
            int maxValue = chars[maxIndex[i]] - '0';
            if(maxValue != iValue){
                chars[i] = (char)(maxValue+'0');
                chars[maxIndex[i]] = (char)(iValue+'0');
                break;
            }
        }
        return Integer.parseInt(new String(chars));
    }
}
// @lc code=end

