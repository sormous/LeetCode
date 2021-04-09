import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=30 lang=java
 *
 * [30] 串联所有单词的子串
 */

// @lc code=start
/**
 * 利用滑动窗口的思想，利用两个窗口来记录所需和当前
 */
class Solution {
    Map<String, Integer> need, window;
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();

        need = new HashMap<>();

        for (String word : words) {
            need.put(word, need.getOrDefault(word, 0)+1);
        }

        //因为单词数组中每个单词长度相等，所以记录单词长度，以便后续遍历和移动
        int word_length = words[0].length();

        //需要循环一个单词长度，分别作为当前窗口的开头位置
        //因为后续增加都是以一个单词长度递增的
        for (int i = 0; i < word_length; i++) {
            //在每次遍历下，都要初始化以下值，首先l、r表示起始位置
            //valid表示窗口中符合的单词个数
            int l=i, r=i;
            int valid = 0;
            //重新初始化window窗口
            window = new HashMap<>();

            while(r+word_length <= s.length()){
                //每次进行比较的单词，以word_length来截取每一个temp单词
                String temp = s.substring(r, r+word_length);
                r += word_length;
                //首先判断当前temp单词是否是need窗口中所需的单词
                //若不是，那么直接将window窗口置空，然后将左位置移动
                if(!need.containsKey(temp)){
                    valid = 0;
                    l = r;
                    window.clear();
                }else{
                    window.put(temp, window.getOrDefault(temp, 0)+1); 
                    valid++;
                    //当window窗口中单词个数大于need窗口所需个数时，则进行窗口的收缩
                    while(window.getOrDefault(temp, 0) > need.getOrDefault(temp, 0)){
                        String temp2 = s.substring(l, l+word_length);
                        valid--;
                        window.put(temp2, window.getOrDefault(temp2, 0)-1);
                        l += word_length;
                    }
                    if(valid == words.length) res.add(l);
                }
            }
        }
        return res;
    }
}
// @lc code=end

