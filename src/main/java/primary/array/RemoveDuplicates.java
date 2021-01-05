package primary.array;

import java.util.HashSet;

/**
 * 删除排序数组中的重复项
 * @Author sannian
 * @Date 2020/12/14 10:55
 * @Version 1.0
 */

public class RemoveDuplicates {
    /**
     * printNums 打印数组的从0到length元素
     *
     * @param nums 输入数组
     * @param length 打印长度
     */
    public static void printNums(int[] nums, int length) {
        for (int i = 0; i < length - 1; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println(nums[length - 1]);
    }

    /**
     * main 函数
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = { 1,1,2,2,3,3,4,5,5};
        int len = unique1(nums);
        printNums(nums, len);
    }

    private static int unique2(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        int index = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0;i<nums.length;i++){
            if(set.add(nums[i])){
                nums[index++] = nums[i];
            }
        }
        return index;
    }

    private static int unique1(int[] nums){
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
