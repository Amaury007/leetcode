package algorithm.primary.array;

import java.util.HashMap;

/**
 * 有效的数独
 * @Author sannian
 * @Date 2021/1/5 16:42
 * @Version 1.0
 */

public class IsValidSudoku {
    /**
     * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
     *
     *     数字 1-9 在每一行只能出现一次。
     *     数字 1-9 在每一列只能出现一次。
     *     数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
     *
     * @param args
     */
    public static void main(String[] args) {
        char[][] nums1 = {{'8','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        boolean bo = printNums(nums1);
        System.out.println(bo);
    }

    /**
     * 抄
     * @param board
     * @return
     */
    private static boolean printNums(char[][] board) {
        // init data
        HashMap<Integer, Integer> [] rows = new HashMap[9];
        HashMap<Integer, Integer>[] columns = new HashMap[9];
        HashMap<Integer, Integer> [] boxes = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<Integer, Integer>();
            columns[i] = new HashMap<Integer, Integer>();
            boxes[i] = new HashMap<Integer, Integer>();
        }
        // validate a board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int n = (int)num;
                    int box_index = (i / 3 ) * 3 + j / 3;

                    // keep the current cell value
                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
                    boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0) + 1);

                    // check if this value has been already seen before
                    if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[box_index].get(n) > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
