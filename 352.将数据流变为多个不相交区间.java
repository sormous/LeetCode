import java.util.Map;
import java.util.TreeMap;

/*
 * @lc app=leetcode.cn id=352 lang=java
 *
 * [352] 将数据流变为多个不相交区间
 */

// @lc code=start
class SummaryRanges {
    TreeMap<Integer, Integer> intervals;

    public SummaryRanges() {
        intervals = new TreeMap<Integer, Integer>();
    }
    
    public void addNum(int val) {
        Map.Entry<Integer, Integer> interval1 = intervals.floorEntry(val);
        Map.Entry<Integer, Integer> interval2 = intervals.ceilingEntry(val+1);

        if(interval1 != null && interval1.getKey()<=val && interval1.getValue()>=val){
            return ;
        }else{
            boolean leftAside = interval1 != null && interval1.getValue()+1==val;
            boolean rightAside = interval2 != null && interval2.getKey()-1==val;
            if(leftAside && rightAside){
                int left = interval1.getKey();
                int right = interval2.getValue();
                intervals.remove(interval1.getKey());
                intervals.remove(interval2.getKey());
                intervals.put(left, right);
            }else if(leftAside){
                intervals.put(interval1.getKey(), val);
            }else if(rightAside){
                int right = interval2.getValue();
                intervals.remove(interval2.getKey());
                intervals.put(val, right);
            }else{
                intervals.put(val, val);
            }
        }
    }
    
    public int[][] getIntervals() {
        int size = intervals.size();
        int[][] res = new int[size][2];
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : intervals.entrySet()) {
            int left = entry.getKey();
            int right = entry.getValue();
            res[count][0] = left;
            res[count][1] = right;
            count++;
        }
        return res;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */
// @lc code=end

