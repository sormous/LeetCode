import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=381 lang=java
 *
 * [381] O(1) 时间插入、删除和获取随机元素 - 允许重复
 */

// @lc code=start
 /*
        nums = [1 , 2, 2, 1, 4, 3, 6, 2]
        indexMapOfValues = {
                        1: [0, 3],
                        2: [1, 2, 7].
                        3: [5],
                        4: [4],
                        6: [6]
                    }
*/
class RandomizedCollection {
    private List<Integer> nums;
    private Map<Integer, Set<Integer>> indexMapOfValues;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        nums = new ArrayList<>();
        indexMapOfValues = new HashMap<>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        nums.add(val);
        Set<Integer> indexSetOfValue = indexMapOfValues.getOrDefault(val, new HashSet<>());
        // the index of new added `value` is `numsSize - 1`
        indexSetOfValue.add(nums.size() - 1);

        indexMapOfValues.put(val, indexSetOfValue);
        // if `value` never appears in nums, the size of `indexSetOfValue` shoud be `1`
        return indexSetOfValue.size() == 1;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!indexMapOfValues.containsKey(val)) return false;
        Set<Integer> indexSetOfValue = indexMapOfValues.get(val);
        // get certain index of value
        int oneIndexOfValue = indexSetOfValue.iterator().next();
        // remove from indexSetOfValue
        indexSetOfValue.remove(oneIndexOfValue);

        /*
            NOTICE: YOU CAN'T DO THIS HERE, ONE CASE IS nums = [1, 2, 3, 4, 5], WHEN YOU'RE TRYING REMOVE 5, IN LINE C, IT WILL BE NULL
            DO THIS STAEMENT BEFORE return
        // if indexSetOfValue is empty, remove from map
        if (indexSetOfValue.size() == 0) {
            indexMapOfValues.remove(value);
        }
        */
        int numsSize = nums.size();
        // replace the value whose index is in `oneIndexOfValue` with `lastValueOfNums`
        int lastValueOfNums = nums.get(numsSize - 1);
        nums.set(oneIndexOfValue, lastValueOfNums);

        // remove index of lastValueOfNums, which equals to `numsSize - 1`
        Set<Integer> indexSetOfLastValue = indexMapOfValues.get(lastValueOfNums);   // C
        indexSetOfLastValue.remove(numsSize - 1);   // A
        // when oneIndexofValue < numsSize - 1, we do the following
        // otherwise, without the if statement, A will be offset by B, nothing works.
        if (oneIndexOfValue < numsSize - 1) {
            indexSetOfLastValue.add(oneIndexOfValue);   // B
        }

        // if indexSetOfValue is empty, remove from map
        if (indexSetOfValue.size() == 0) {
            indexMapOfValues.remove(val);
        }

        nums.remove(numsSize - 1);
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return nums.get((int)(Math.random()*nums.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
// @lc code=end

