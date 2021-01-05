package primary.array;


/**
 * 加一
 * @Author sannian
 * @Date 2020/12/25 17:01
 * @Version 1.0
 */

public class PlusOne {
    /**
     * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     *示例 2：
     * 输入：digits = [4,3,2,1]
     * 输出：[4,3,2,2]
     * 解释：输入数组表示数字 4321。
     * 示例 3：
     * 输入：digits = [0]
     * 输出：[1]
     * 提示：
     *     1 <= digits.length <= 100
     *     0 <= digits[i] <= 9
     * @param args
     */
    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        int[] nums3 = printNums(nums2);
        System.out.println(1);
    }


    /**
     * 抄
     * @param digits
     * @return
     */
    private static int[] printNums(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] += 1;
                return digits;
            }

        }
        //如果所有位都是进位，则长度+1
        digits= new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
