package primary.array;

/**
 * 买卖股票的最佳时机 II
 * @Author sannian
 * @Date 2020/12/14 11:29
 * @Version 1.0
 */

public class MaxProfit {

    public static void main(String[] args) {
        int[] nums = {7,1,5,3,6,4};
        int len = unique1(nums);
        System.out.println(len);
    }

    private static int unique1(int[] nums) {
        int maxnum = 0;
        if (nums.length < 2){
            return maxnum;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]-nums[i-1]>0){
                maxnum += nums[i] - nums[i-1];
            }
        }
        return maxnum;
    }
}
