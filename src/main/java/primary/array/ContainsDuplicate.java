package primary.array;

import java.util.Arrays;

/**
 * 存在重复元素
 * @Author sannian
 * @Date 2020/12/23 18:05
 * @Version 1.0
 */

public class ContainsDuplicate {
    /**
     * 给定一个整数数组，判断是否存在重复元素。
     * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = { 1,2,3,4,5,6,7,8,9};
        System.out.println( printNums2(nums));
    }

    private static boolean printNums(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j] && i!=j){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean printNums2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i <nums.length-1 ; i++) {
            if (nums[i]==nums[i+1]){
                return true;
            }
        }
        return false;
    }

}
