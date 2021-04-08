package algorithm.primary.array;

/**
 * 旋转图像
 * @Author sannian
 * @Date 2021/1/6 17:01
 * @Version 1.0
 */

public class RotateImg {
    /**
     给定一个 n × n 的二维矩阵表示一个图像。
     将图像顺时针旋转 90 度。
     说明：
     你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像
     *抄的
     * @param args
     */
    public static void main(String[] args) {
        int[][] nums1 = {{7,4,1},
                          {8,5,2},
                          {9,6,3}};
        printNums(nums1);
        System.out.println(1);
    }

    private static void printNums(int[][] matrix) {
        int n = matrix.length;
        //水平翻转
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < n; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = temp;
            }
        }
        //主对角线翻转
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
