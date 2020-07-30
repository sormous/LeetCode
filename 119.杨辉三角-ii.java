import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=119 lang=java
 *
 * [119] 杨辉三角 II
 */

// @lc code=start
/**
 * 杨辉三角的每一行满足组合公式C(n,i)=n!/(i!*(n-i)!)，且第(i+1)项是第i项的倍数=(n-i)/(i+1);
 * 第n行从左至右可看作C(n,0)->C(n,n)
 */
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>(rowIndex+1);
        long s = 1;
        for(int i=0; i<=rowIndex; i++){
            res.add((int)s);
            s = s*(rowIndex-i)/(i+1);
        }
        return res;
    }
}
// @lc code=end

