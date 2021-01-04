import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=976 lang=java
 *
 * [976] 三角形的最大周长
 */

// @lc code=start
/**
 * 先对长度数组进行排序，然后从最大的三个值开始遍历，判断是否可以构成三角形
 * 若可以，则计算边长，并跳出循环，得到最大的周长；
 * 若没有可以构成三角形的三条边，那么就返回0.
 */
class Solution {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        int res = 0;
        int l = A.length-1;
        while(l-2>=0){
            if(A[l-2] + A[l-1] > A[l]){
                res = A[l-2]+A[l-1]+A[l];
                break;
            }
            l--;
        }
        return res;
    }
}
// @lc code=end

