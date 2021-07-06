import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=1418 lang=java
 *
 * [1418] 点菜展示表
 */

// @lc code=start
class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        Set<String> NameSet = new HashSet<>();
        Map<Integer, Map<String, Integer>> foodCnt = new HashMap<>();
        //根据用户订单建立菜品名集合和食物数量
        for(List<String> order : orders){
            NameSet.add(order.get(2));
            int id = Integer.parseInt(order.get(1));
            Map<String, Integer> map = foodCnt.getOrDefault(id, new HashMap<>());
            map.put(order.get(2), map.getOrDefault(order.get(2), 0)+1);
            foodCnt.put(id, map);
        }

        //按字母序排序
        List<String> names = new ArrayList<>();
        for (String name:NameSet) {
            names.add(name);
        }
        Collections.sort(names);
        List<Integer> ids = new ArrayList<>();
        for (Integer id : foodCnt.keySet()) {
            ids.add(id);
        }
        Collections.sort(ids);

        List<List<String>> res = new ArrayList<List<String>>();
        List<String> header = new ArrayList<>();
        //首先对header行进行添加和设置
        header.add("Table");
        for (String name : names) {
            header.add(name);
        }
        res.add(header);

        //然后根据每一桌的id，对其点的菜进行计数显示
        int m = ids.size(), n = names.size();
        for (int i = 0; i < m; i++) {
            int id = ids.get(i);
            Map<String, Integer> cnt = foodCnt.get(id);
            List<String> temp = new ArrayList<>();
            temp.add(Integer.toString(id));
            for (int j = 0; j < n; j++) {
                temp.add(Integer.toString(cnt.getOrDefault(names.get(j), 0)));
            }
            res.add(temp);
        }

        return res;
    }
}
// @lc code=end

