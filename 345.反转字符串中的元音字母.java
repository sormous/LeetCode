import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
 * @lc app=leetcode.cn id=345 lang=java
 *
 * [345] 反转字符串中的元音字母
 */

// @lc code=start
/**
 * 利用双指针，分别从字符串头尾开始判断，
 * 当指针遇到元音字符，则暂停等待另一个指针遇到元音字符时进行交换
 * 利用一个HashSet来存储元音字符，方便后续查找
 */
class Solution {
    private static HashSet<Character> vowels = new HashSet<>(
        Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
    public String reverseVowels(String s) {
        if(s == null) return null;
        int l = 0, r = s.length()-1;
        char[] res = new char[s.length()];
        while(l<=r){
            char cl = s.charAt(l);
            char cr = s.charAt(r);
            if(!vowels.contains(cl)){
                res[l++] = cl;
            }else if(!vowels.contains(cr)){
                res[r--] = cr;
            }else{
                res[l++] = cr;
                res[r--] = cl;
            }
        }
        return new String(res);
    }
}
// @lc code=end

