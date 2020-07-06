/*
 * @lc app=leetcode.cn id=204 lang=java
 *
 * [204] 计数质数
 */

// @lc code=start
/**
 * 厄拉多塞筛法. 
 * 比如说求20以内质数的个数,首先0,1不是质数.2是第一个质数,
 * 然后把20以内所有2的倍数划去.2后面紧跟的数即为下一个质数3,
 * 然后把3所有的倍数划去.3后面紧跟的数即为下一个质数5,再把5所有的倍数划去.以此类推.
 */
class Solution {
    public int countPrimes(int n) {
        // if(n == 1) return 0;
        // int count = 0;
        // for (int i = 2; i < n; i++){
        //   if(isPrime(i)) count++;
        // }
        // return count;
        
        int[] a = new int[n]; //小于n的自然数，所以数组长度为n即可
        int count = 0;
        //首先生成一个除0和1位置上全1的数组
        for (int i = 2; i < n; i++){
            a[i] = 1;
        }

        for (int i = 2; i < n; i++) {
            //若当前数组中位置对应值为1，则计数加1
            if(a[i] == 1) count++;
            //然后将该数的所有倍数位置上的值全部置为0
            for(int j=2*i; j<n; j+=i){
                a[j] = 0;
            }
        }
        return count;
    }
    //判断某自然数是否为质数
    // private boolean isPrime(int n){
    //     if(n == 2) return true;
    //     int half = (int)Math.sqrt(n);
    //     boolean flag = true;
    //     for (int i = 2; i <= half; i++) {
    //         if(n % i == 0){
    //             flag = false;
    //             break;
    //         }
    //     }
    //     return flag;
    // }
}
// @lc code=end

