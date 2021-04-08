package algorithm.primary.array;

import java.util.Arrays;

/**
 * 只出现一次的数字
 * @Author sannian
 * @Date 2020/12/24 11:10
 * @Version 1.0
 */

public class SingleNumber {

    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     *
     * 说明：
     * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        System.out.println( printNums(nums));
    }

    private static int printNums(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length-1){
                return nums[i];
            }
            if (nums[i]==nums[i +1]){
                ++i;
            }else {
                return nums[i];
            }
        }
        return 0;
    }

    /**
     * 异或，官网学到了
     * @param nums
     * @return
     */
    private static int printNums2(int[] nums) {
        int single = 0;
        for (int num : nums) {
        single ^= num;
        }
        return single;
    }
}
