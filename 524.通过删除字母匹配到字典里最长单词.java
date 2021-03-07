/*
 * @lc app=leetcode.cn id=524 lang=java
 *
 * [524] 通过删除字母匹配到字典里最长单词
 */

// @lc code=start
/**
 * 通过删除字符串字母匹配单词，既是判断单词是否为字符串的子串
 */
class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        //声明一个字符串用来记录最长单词
        String res = "";
        for(String word:dictionary){
            int l1 = res.length(), l2 = word.length();
            //如果当前记录的res长度大于后续遍历单词长度，或者当长度相等时，字典顺序更小时，则直接跳过循环，不管是否满足子串要求
            if(l1 > l2 || (l1 == l2 && res.compareTo(word) < 0)){
                continue;
            }
            if(isSubstr(s, word)){
                res = word;
            }
        }
        return res;
    }

    //判断单词是否为字符串的子串
    private boolean isSubstr(String s, String word){
        //利用双指针，分别从两个字符串头部开始遍历
        int i=0, j=0;
        while(i<s.length() && j<word.length()){
            if(s.charAt(i) == word.charAt(j)){
                j++;
            }
            i++;
        }
        return j==word.length();
    }
}
// @lc code=end

