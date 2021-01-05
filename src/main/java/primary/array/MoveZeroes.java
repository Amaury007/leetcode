package primary.array;

import java.util.Arrays;

/**
 * 移动零
 * @Author sannian
 * @Date 2020/12/26 14:56
 * @Version 1.0
 */

public class MoveZeroes {

    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * 示例:
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * 说明:
     *     必须在原数组上操作，不能拷贝额外的数组。
     *     尽量减少操作次数。
     */
    public static void main(String[] args) {
        int[] nums = {4,1,2,0,0,1,2};
        System.out.println( moveZeroes(nums));
        System.out.println( moveZeroes(nums));
    }

    public static int[] moveZeroes(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
                    if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
        return nums;
    }

    public static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
