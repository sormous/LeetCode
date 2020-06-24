/*
 * @lc app=leetcode.cn id=264 lang=java
 *
 * [264] 丑数 II
 */

// @lc code=start
/**
 * 三指针法。
 * 初始化一个长度为n的丑数数组，将第一个位置赋值为1，
 * 分别用p2,p3,p5表示质因子2，3，5该乘以的数的坐标，
 * 然后判断3个质因子分别乘以坐标对应的数值中的最小值依次放入丑数数组中，
 * 循环放满丑数数组之后，返回最后一个值即为所需值。
 */
class Solution {
    public int nthUglyNumber(int n) {
        int ugly[] = new int[n]; //丑数数组
        ugly[0] = 1;
        int p2 = 0, p3=0, p5=0; //质因子的位置指针
        int min = 0; //循环中作比较
        for (int i = 1; i <n; i++) {
            int a = ugly[p2]*2;
            int b = ugly[p3]*3;
            int c = ugly[p5]*5;
            min = minofthree(a, b, c);
            ugly[i] = min;
            if(min == a) p2++;
            if(min == b) p3++;
            if(min == c) p5++;
        }
        return ugly[n-1];
    }

    public int minofthree(int a, int b, int c){
        int temp = a<b ? a:b;
        return temp<c ? temp:c;
    }
}
// @lc code=end

