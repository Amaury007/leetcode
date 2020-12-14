package primary.array;

/**
 * @Author sannian
 * @Date 2020/12/14 11:29
 * @Version 1.0
 */

public class MaxProfit {
    private int res;
    public static void main(String[] args) {
        int[] nums = {7,1,5,3,6,4};
        MaxProfit ms = new MaxProfit();
        int len = ms.maxProfit(nums);
        System.out.println(len);
    }
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        this.res = 0;
        dfs(prices, 0, len, 0, res);
        return this.res;
    }

    /**
     * @param prices 股价数组
     * @param index  当前是第几天，从 0 开始
     * @param status 0 表示不持有股票，1表示持有股票，
     * @param profit 当前收益
     */
    private void dfs(int[] prices, int index, int len, int status, int profit) {

        if (index == len) {
            this.res = Math.max(this.res, profit);
            return;
        }

        dfs(prices, index + 1, len, status, profit);

        if (status == 0) {
            // 可以尝试转向 1
            dfs(prices, index + 1, len, 1, profit - prices[index]);

        } else {
            // 此时 status == 1，可以尝试转向 0
            dfs(prices, index + 1, len, 0, profit + prices[index]);
        }
    }
}
