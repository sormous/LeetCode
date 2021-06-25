import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=752 lang=java
 *
 * [752] 打开转盘锁
 */

// @lc code=start
class Solution {
    public int openLock(String[] deadends, String target) {
        if("0000".equals(target)){
            return 0;
        }
        Set<String> dead = new HashSet<>();
        for (String deadend : deadends) {
            dead.add(deadend);
        }
        if(dead.contains("0000")){
            return -1;
        }
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.offer("0000");
        visited.add("0000");

        int step = 0;
        while(!q.isEmpty()){
            int size = q.size();
            step++;
            for (int i = 0; i < size; i++) {
                String temp = q.poll();
                for (String nums : rotate(temp)) {
                   if(!dead.contains(nums) && !visited.contains(nums)){
                        if(nums.equals(target)){
                            return step;
                        }
                        q.offer(nums);
                        visited.add(nums);
                    }
                }
            }
        }
        return -1;
    }

    public char pre(char x){
        return x == '0' ? '9' : (char)(x-1);
    }
    public char next(char x){
        return x == '9' ? '0' : (char)(x+1);
    }

    public List<String> rotate(String s){
        List<String> res = new ArrayList<>();
        char[] nums = s.toCharArray();
        for (int i = 0; i < 4; i++) {
            char num = nums[i];
            nums[i] = pre(num);
            res.add(new String(nums));
            nums[i] = next(num);
            res.add(new String(nums));
            nums[i] = num;
        }
        return res;
    }
}
// @lc code=end

