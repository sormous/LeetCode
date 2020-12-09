import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=692 lang=java
 *
 * [692] 前K个高频单词
 */

// @lc code=start
/**
 * 计算每个单词的频率，然后将其添加到存储到大小为 k 的小根堆中。
 * 它将频率最小的候选项放在堆的顶部。最后，我们从堆中弹出最多 k 次，
 * 并反转结果，就可以得到前 k 个高频单词。
 * 
 * 在 Python 中，我们使用 heapq\heapify，
 * 它可以在线性时间内将列表转换为堆，从而简化了我们的工作。
 */
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        //首先构建hashmap存储每一个单词及其出现的次数
        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0)+1);
        }
        //然后构建小根堆heap，用来存储后续的元素
        PriorityQueue<String> heap = new PriorityQueue<String>(
            (w1, w2) -> count.get(w1).equals(count.get(w2)) ?
            w2.compareTo(w1) : count.get(w1) - count.get(w2)  
        );
        //将map中的字符存储进heap中，当size>k之后，在每次插入时，同时弹出一个元素
        //保证小根堆中仅存在k个元素，即为频率最大的k个元素
        //所以size>k之后每次插入，同时弹出频次最小的元素
        for (String word : count.keySet()) {
            heap.offer(word);
            if(heap.size() > k) heap.poll();
        }
        //最后创建结果列表，存储结果，从小根堆中弹出元素，然后反转结果即可
        List<String> res = new ArrayList<>();
        while(!heap.isEmpty()) res.add(heap.poll());
        Collections.reverse(res);
        return res;
    }
}
// @lc code=end

