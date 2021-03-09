import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=93 lang=java
 *
 * [93] 复原 IP 地址
 */

// @lc code=start
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        StringBuffer tempAddress = new StringBuffer();
        IP(0, tempAddress, res, s);
        return res;

    }
    //利用回溯的思想，进行IP段的判断并修改格式并添加
    private void IP(int k, StringBuffer tempAddress, List<String> res, String s){
        //当满足ip地址长度格式或者字符串已经选完为空时
        if(k == 4 || s.length() == 0){
            if(k == 4 && s.length() == 0){
                res.add(tempAddress.toString());
            }
            return ;
        }
        //开始遍历，遍历条件限制在字符串s的长度内并且最多选3个
        for (int i = 0; i < s.length() && i <= 2; i++) {
            //如果遍历位置不在首位，且首位已经为0，则直接跳出该遍历循环
            if(i != 0 && s.charAt(0) == '0'){
                break;
            }
            //申明变量记录该次遍历位置得到的子字符串，作为该IP地址段
            String part = s.substring(0, i+1);
            //然后判断该IP段是否满足小于等于255
            if(Integer.valueOf(part) <= 255){
                //非第一段，则需要在前添加 "."
                if(tempAddress.length() != 0){
                    part = "." + part;
                }
                tempAddress.append(part);
                //需要修改k值和s字符串的值，s字符串变为未选择的子字符串
                IP(k+1, tempAddress, res, s.substring(i+1));
                //回溯思想的重点，就是在递归结束后，删除本次添加的字符
                tempAddress.delete(tempAddress.length() - part.length(), tempAddress.length());
            }
        }

    }
}
// @lc code=end

