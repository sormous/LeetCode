import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=290 lang=java
 *
 * [290] 单词规律
 */

// @lc code=start
class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] string = str.split(" ");
        if (pattern.length() != string.length) return false;
        //利用hashmap存储对应关系,方便比较
        HashMap<Character, String> map = new HashMap<>();

        for(int i=0; i<string.length; i++){
            char temp = pattern.charAt(i);
            if(map.containsKey(temp)){
                if(!map.get(temp).equals(string[i])){
                    return false;
                }
            }
            else{
                if(map.containsValue(string[i])){
                    return false;
                }
                else{
                    map.put(temp, string[i]);
                }
            }
        }
        return true;
    }
}
// @lc code=end

