/*
 * @lc app=leetcode.cn id=1089 lang=java
 *
 * [1089] 复写零
 */

// @lc code=start
/**
 * 1、每个0会让长度+1；数组长度是上限。
 * 扫描数组： 非0，count+1 遇到0，count+2

如果count>=arrSize，说明扫描到这个位置就可以了，后面的不用管。
等下复制，最后一位也是基于当前这个位置来定。

这里有>=arrSize，是因为：当最后扫描位置为0时，0会被挤掉一个，而count加了2，
所以是count > arrSize 如果最后扫描位置不为0，则被挤掉就行，count应该是==arrSize

2、从扫描到的最后位置，倒着往原数组复制。 也得考虑最后一个是否为0（即挤掉一个0）
 */
class Solution {
    public void duplicateZeros(int[] arr) {
        int i;
        int count = 0;
        for(i=0; i<arr.length; i++){
            count++;
            if(arr[i] == 0){
                count++; //遇0则再加1，提前保留位置
            }
            if(count >= arr.length) break;
        }
        for(int j=arr.length-1; j>=0; j--){
            if(arr[i] != 0){
                arr[j] = arr[i];
            }else if(arr[i] == 0 && count>arr.length && j == arr.length-1){
                //若最后一个位置为0，新增0的话位置不够，只需要1个即可
                arr[j] = arr[i];
            }else{
                //若不是最后一个位置，则在当前位置和前一个位置置0
                arr[j] = arr[i];
                arr[j-1] = arr[i];
                j--;
            }
            i--;
        }
    }
}
// @lc code=end

