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
 */
class Solution {
    public String reverseVowels(String s) {
        if(s.length() <= 1) return s;
        char[] l = s.toCharArray();
        String Vowels = "aeiouAEIOU";
        int i = 0, j = s.length()-1;
        while(i<j){
            if(Vowels.indexOf(l[i]) != -1 && Vowels.indexOf(l[j]) != -1){
                char temp = l[i];
                l[i] = l[j];
                l[j] = temp;
                i++;
                j--;
            }
            else if(Vowels.indexOf(l[i]) != -1){
                j--;
            }
            else if(Vowels.indexOf(l[j]) != -1){
                i++;
            }else{
                i++;
                j--;
            }
        }
        return new String(l);
    }
}
// @lc code=end

