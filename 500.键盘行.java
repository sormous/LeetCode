import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=500 lang=java
 *
 * [500] 键盘行
 */

// @lc code=start
class Solution {
    public String[] findWords(String[] words) {
        List<String> list = new ArrayList<String>(Arrays.asList(words));
        //用一个字符数组记录键盘每一行的字符
        String[] keyboards = { "qwertyuiop", "asdfghjkl", "zxcvbnm"};
        for(int i=list.size()-1; i>=0; i--){
            for (String keyboard : keyboards) {
                //先判断第一个字符是否为这一行字符，简化判断，然后判断后续字符是否为同一行，不是则剔除该字符串
                if(keyboard.indexOf(list.get(i).toLowerCase().charAt(0)) != -1
                    && isexist(keyboard, list.get(i).toLowerCase())){
                        list.remove(i);
                        break;
                    }
            }
        }

        return list.toArray(new String[list.size()]);
    }

    //声明一个方法，判断某字符串中的字符是否在键盘同一行，从i=1开始，是因为前面优先判断了第一个是否为该行
    public boolean isexist(String keyboard, String str){
        for (int i = 1; i < str.length(); i++) {
            if(keyboard.indexOf(str.charAt(i)) == -1){
                return true;
            }
        }
        return false;
    }
}
// @lc code=end

