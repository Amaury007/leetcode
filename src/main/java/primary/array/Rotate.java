package primary.array;

/**
 * 旋转数组
 * @Author sannian
 * @Date 2020/12/14 15:27
 * @Version 1.0
 */

public class Rotate {
    /**
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数
     * 输入: [1,2,3,4,5,6,7] 和 k = 3
     * 输出: [5,6,7,1,2,3,4]
     * 解释:
     * 向右旋转 1 步: [7,1,2,3,4,5,6]
     * 向右旋转 2 步: [6,7,1,2,3,4,5]
     * 向右旋转 3 步: [5,6,7,1,2,3,4]
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = { 1,2,3,4,5,6,7,8,9};
        printNums(nums,3);
    }

    private static void printNums(int[] nums,int k) {
        int len = nums.length;
        int[] returnnums = nums.clone();
        for (int i = 0; i < len; i++) {
            if (i<k){
                nums[i] = returnnums[len-k+i];
            }else{
                nums[i] = returnnums[i-k];
            }
        }
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i]);
        }
    }


}
