import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=986 lang=java
 *
 * [986] 区间列表的交集
 */

// @lc code=start
class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res = new ArrayList<>();
        int i=0, j=0;
        while(i<firstList.length && j<secondList.length){
            //分别记录遍历两个区间列表，当前位置的区间的左右位置值
            int l1 = firstList[i][0], r1 = firstList[i][1];
            int l2 = secondList[j][0], r2 = secondList[j][1];
            //当两个区间的右界都大于等于对方的左界值时，说明有交集
            if(l1<=r2 && r1>=l2){
                int[] temp = new int[2];
                //交集左界为max(l1,l2)，右界为min(r1,r2)
                temp[0] = Math.max(l1, l2);
                temp[1] = Math.min(r1, r2);
                res.add(temp);
            }
            //更新区间，比较右边界，较小的一个，更新指针
            if(r1 < r2){
                i++;
            }else{
                j++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
// @lc code=end

