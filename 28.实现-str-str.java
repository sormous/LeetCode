/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] 实现 strStr()
 */

// @lc code=start
class Solution {
    /**
     * 给定一个主字符串，和一个需求字符串，
     * 在主字符串中寻找需求字符串出现的第一个位置，若不存在则返回-1
     * 
     * 利用KMP算法实现
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        //先判断特殊情况下，应该返回什么值
        if(needle == null || haystack == null){
            return -1;
        }
        if(needle.length() > haystack.length()){
            return -1;
        }
        if("".equals(haystack)){
            if("".equals(needle)){
                return 0;
            }else{
                return -1;
            }
        }else{
            if("".equals(needle)){
                return 0;
            }
        }

        return kmpIndex(haystack, needle);
    }

    private int kmpIndex(String haystack, String needle) {
        int i=0;
        int j=0;
        int[] next = next(needle);
        while(i<haystack.length() && j<needle.length()){
            if(j == -1 || haystack.charAt(i) == needle.charAt(j)){
                ++i;
                ++j;
            }else{
                j = next[j];
            }
        }

        if(j==needle.length()){
            return i-j;
        }else{
            return -1;
        }
    }

    private int[] next(String needle) {
        int[] next = new int[needle.length()];
        next[0] = -1;
        int i=0;
        int j=-1;
        int k=needle.length()-1;
        while(i < k){
            if(j == -1 || needle.charAt(i) == needle.charAt(j)){
                ++i;
                ++j;
                if(needle.charAt(i) != needle.charAt(j)){
                    next[i] = j;
                }else{
                    next[i] = next[j];
                }
            }else{
                j = next[j];
            }
        }
        return next;
    }
}
// @lc code=end

