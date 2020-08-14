/*
 * @lc app=leetcode.cn id=443 lang=java
 *
 * [443] 压缩字符串
 */

// @lc code=start
class Solution {
    public int compress(char[] chars) {
        //记录最后所到数组的长度
        int ans = 0;
        //初始设定i=0数组开头开始，cnt=1计数字符个数
        for(int i=0, cnt=1; i<chars.length; i++, cnt++){
            //当到最后一个字符或者当前字符不等于下一个字符时
            if(i+1 == chars.length || chars[i] != chars[i+1]){
                //则ans记录的当前位置的字符为i位置的字符
                chars[ans++] = chars[i];
                //若当前字符个数大于1时
                if(cnt > 1){
                    //将次数int转换成String类型
                    String times = Integer.toString(cnt);
                    //遍历字符进行添加
                    for (int j = 0; j < times.length(); j++) {
                        chars[ans++] = times.charAt(j);
                    }
                }
                cnt = 0;
            }
        }
        return ans;
    }
}
// @lc code=end

