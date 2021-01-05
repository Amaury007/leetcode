package primary.array;

import java.util.*;

/**
 * 两个数组的交集 II
 * @Author sannian
 * @Date 2020/12/24 16:57
 * @Version 1.0
 */

public class Intersect {
    /**
     * 示例 2:
     * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出：[4,9]
     * 说明：
     *     输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
     *     我们可以不考虑输出结果的顺序。
     * 进阶：
     *     如果给定的数组已经排好序呢？你将如何优化你的算法？
     *     如果 nums1 的大小比 nums2 小很多，哪种方法更优？
     *     如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
     * @param args
     */
    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        int[] nums3 = printNums(nums1,nums2);
        System.out.println(1);
    }

    /**
     * 双指针
     * @param nums1
     * @param nums2
     * @return
     */
    private static int[] printNums(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1 = nums1.length, length2 = nums2.length;
        int[] intersection = new int[Math.min(length1, length2)];
        int index1 = 0, index2 = 0, index = 0;
        while (index1 < length1 && index2 < length2) {
            if (nums1[index1] < nums2[index2]) {
                index1++;
            } else if (nums1[index1] > nums2[index2]) {
                index2++;
            } else {
                intersection[index] = nums1[index1];
                index1++;
                index2++;
                index++;
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }


    /**
     * HashMap 重点getOrDefault方法的应用
     * @param nums1
     * @param nums2
     * @return
     */
    private static  int[] printNums2(int[] nums1,int[] nums2){
        if (nums1.length > nums2.length) {
            return printNums2(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums1) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        int[] intersection = new int[nums1.length];
        int index = 0;
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                intersection[index++] = num;
                count--;
                if (count > 0) {
                    map.put(num, count);
                } else {
                    map.remove(num);
                }
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }

}
