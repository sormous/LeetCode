import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1711 lang=java
 *
 * [1711] 大餐计数
 */

// @lc code=start

class Solution {
    public int countPairs(int[] deliciousness){
        Map<Integer, Integer> map = new HashMap<>();
        int mod = 1000000007;
        int res = 0;

        for (int d : deliciousness) {
            int powerof2 = 1;
            //因为数字最大为2^20, 2^20 + 2^20 = 2^21为可能的最大值，不可能再大啦！
            for (int i = 0; i <= 21; i++) {
                if(powerof2 >= d && map.containsKey(powerof2-d)){
                    res += map.get(powerof2-d);
                    res = res%mod;
                }
                powerof2 *= 2;
            }
            map.put(d, map.getOrDefault(d, 0)+1);
        }

        return res;
    }


    //下述方法超时，O(n^2)
    // public int countPairs(int[] deliciousness) {
    //     int res = 0;
    //     Map<Integer, Integer> map = new HashMap<>();
    //     for (int d : deliciousness) {
    //         map.put(d, map.getOrDefault(d, 0) + 1);
    //     }
    //     for (int key1 : map.keySet()){
    //         for (int key2 : map.keySet()) {
    //             if(key1 == key2) continue;
    //             if(is2Power(key1+key2)){
    //                 res += map.get(key1)*map.get(key2);
    //             }
    //         }
    //     }
    //     res /= 2;
    //     for (int key : map.keySet()){
    //         if(is2Power(key+key) && map.get(key) >= 2){
    //             int n = map.get(key);
    //             res += n*(n-1)/2;
    //         }
    //     }
    //     return res;
    // }

    // private boolean is2Power(int sum){
    //     if(sum == 0) return false;
    //     while(sum != 1){
    //         if(sum % 2 != 0){
    //             return false;
    //         }
    //         sum /= 2;
    //     }
    //     return true;
    // }
}

// @lc code=end

