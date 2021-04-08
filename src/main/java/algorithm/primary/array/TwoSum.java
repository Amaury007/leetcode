package algorithm.primary.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * @Author sannian
 * @Date 2021/01/05 11:10
 * @Version 1.0
 */

public class TwoSum {

    /**
     *给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     *
     * 你可以按任意顺序返回答案。
     * 示例 1：
     *
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[0,1]
     * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {3,1,3};
        int target = 6;
        int[] i = printNums(nums,target);
        System.out.println();
    }

    private static int[] printNums(int[] nums,int target) {
        int[] returnNum = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i!=j){
                    if (nums[i]+nums[j]==target){
                        int[] returnNums ={i,j};
                        returnNum = returnNums;
                    }
                }
            }
        }
        return returnNum;
    }

    /**
     * 官网
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }

}
