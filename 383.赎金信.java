import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=383 lang=java
 *
 * [383] 赎金信
 */

// @lc code=start
/**
 * 利用hashmap存储magazine中各字符元素并记录对应字符的个数
 * 然后遍历ransomNote中的字符与个数是否满足hashmap中的值
 */
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < magazine.length(); i++) {
            if(!map.containsKey(magazine.charAt(i))){
                map.put(magazine.charAt(i), 1);
            }else{
                map.replace(magazine.charAt(i), map.get(magazine.charAt(i))+1);
            }
        }
        System.out.println(map);
        for (int i = 0; i < ransomNote.length(); i++){
            if(map.containsKey(ransomNote.charAt(i)) && map.get(ransomNote.charAt(i))>=1){
                map.replace(ransomNote.charAt(i), map.get(ransomNote.charAt(i))-1);
            }else{
                return false;
            }
        }
        
        return true;
    }
}
// @lc code=end

