import java.util.Random;

/*
 * @lc app=leetcode.cn id=912 lang=java
 *
 * [912] 排序数组
 */

// @lc code=start
/**
 * 各种排序算法：快速排序，选择排序，插入排序，希尔排序，桶排序，基数排序，归并排序，堆排序
 */
class Solution {
    public int[] sortArray(int[] nums) {
        qsort(nums, 0, nums.length-1);
        return nums;
    }

    //快速排序
    private void qsort(int[] nums, int l, int r){
        if(l<r){
            int pos = randomPart(nums, l, r);
            qsort(nums, l, pos-1);
            qsort(nums, pos+1, r);
        }
    }

    private int randomPart(int[] nums, int l, int r){
        int i = new Random().nextInt(r-l+1)+l;
        swap(nums, r, i);
        return partition(nums, l, r);
    }

    private int partition(int[] nums, int l, int r){
        int pivot = nums[r];
        int i = l-1;
        for (int j = l; j <= r-1; j++) {
            if(nums[j] <= pivot){
                i += 1;
                swap(nums, i, j);
            }
        }
        swap(nums, i+1, r);
        return i+1;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// @lc code=end

