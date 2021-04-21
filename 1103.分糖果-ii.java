/*
 * @lc app=leetcode.cn id=1103 lang=java
 *
 * [1103] 分糖果 II
 */

// @lc code=start
class Solution {
    /**
     * 分别利用temp和i记录若糖果数量足够应该分的糖果和应该分配的同学下标
     * 若最后不够，那么直接将剩余的分配的所指下标同学 
     * @param candies
     * @param num_people
     * @return  int[] res
     */
    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        int temp = 1;
        int i = 0;
        while(temp <= candies){
            i = i%num_people;
            res[i] += temp;
            candies -= temp;
            temp++;
            i++;
        }
        res[i%num_people] += candies;

        return res;
    }
}
// @lc code=end

