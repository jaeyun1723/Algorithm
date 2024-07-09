class Solution {
    static int[][] arr;
    static int ZERO, ONE;

    public static boolean equal(int x, int y, int length) {
        for (int i = x; i < x + length; i++) {
            for (int j = y; j < y + length; j++) {
                if (arr[i][j] != arr[x][y])
                    return false;
            }
        }
        return true;
    }

    public static void quad(int x, int y, int length) {
        if (equal(x, y, length)) {
            if (arr[x][y] == 1) ONE++;
            else ZERO++;
            return;
        }
        quad(x, y, length / 2);
        quad(x, y + length / 2, length / 2);
        quad(x + length / 2, y, length / 2);
        quad(x + length / 2, y + length / 2, length / 2);
    }


    public int[] solution(int[][] arr) {
        int[] answer = {0, 0};
        Solution.arr = arr;
        quad(0, 0, arr.length);
        answer[0] = ZERO;
        answer[1] = ONE;
        return answer;
    }
}