import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=290 lang=java
 *
 * [290] 单词规律
 */

// @lc code=start
class Solution {
    public boolean wordPattern(String pattern, String str) {
        //首先将字符串按空格分开，变成单词数组
        String[] string = str.split(" ");
        //如果pattern的长度不等于单词数组的长度，则直接返回false
        if (pattern.length() != string.length) return false;
        //利用hashmap存储对应关系,方便比较
        HashMap<Character, String> map = new HashMap<>();
        //然后遍历单词数组，利用pattern-word作为map的k-v键值对
        for(int i=0; i<string.length; i++){
            char temp = pattern.charAt(i);
            //若当前pattern中的字符，存在于map中，则比较其对应的value是否等于string[i]
            if(map.containsKey(temp)){
                if(!map.get(temp).equals(string[i])){
                    return false;
                }
            }
            //若map不存在该键
            else{
                //但已经存在该string[i]的value，则同样返回false
                if(map.containsValue(string[i])){
                    return false;
                }
                //否则添加该键值对
                else{
                    map.put(temp, string[i]);
                }
            }
        }
        return true;
    }
}
// @lc code=end

