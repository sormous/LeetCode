import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=1046 lang=java
 *
 * [1046] 最后一块石头的重量
 */

// @lc code=start
/**
 * 将所有石头的重量放入最大堆中。每次依次从队列中取出最重的两块石头 a 和 b，必有 a≥b。
 * 如果 a>b，则将新石头 a−b 放回到最大堆中；如果 a=b，两块石头完全被粉碎，因此不会产生新的石头。重复上述操作，直到剩下的石头少于 2 块。
 */
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b)->b-a);
        for (int stone : stones) {
            pq.offer(stone);
        }
        while(pq.size() > 1){
            int a = pq.poll();
            int b = pq.poll();
            if(a > b){
                pq.offer(a-b);
            }
        }
        return pq.isEmpty() ? 0:pq.poll();
    }
}
// @lc code=end

