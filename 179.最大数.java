import java.util.Arrays;
import java.util.Comparator;

/*
 * @lc app=leetcode.cn id=179 lang=java
 *
 * [179] 最大数
 */

// @lc code=start
class Solution {
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0){
            return "";
        }
        String[] strArr = new String[nums.length];
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = String.valueOf(nums[i]);
        }
        //重写排序规则
        //compareTo方法返回值为1（升序），0，-1（降序）
        Arrays.sort(strArr, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                return (o2+o1).compareTo(o1+o2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String strarr : strArr) {
            sb.append(strarr);
        }

        String result = sb.toString();
        //特殊情况，若干个0时，直接返回0
        if(result.charAt(0) == '0'){
            result = "0";
        }
        return result;
    }
}
// @lc code=end

