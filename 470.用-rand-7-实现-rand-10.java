/*
 * @lc app=leetcode.cn id=470 lang=java
 *
 * [470] 用 Rand7() 实现 Rand10()
 */

// @lc code=start
/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        int a, b;
        int temp;
        //通过舍弃策略，两次利用随机7方法，得到1~49的随机数
        //然后舍弃最后的41~49
        //即可等概率的得到1~40
        do{
            a = rand7();
            b = rand7();
            temp = a + (b-1)*7;
        }while(temp > 40);
        //最后实现1~10的随机值返回
        return 1+(temp-1) % 10;
    }
}
// @lc code=end

