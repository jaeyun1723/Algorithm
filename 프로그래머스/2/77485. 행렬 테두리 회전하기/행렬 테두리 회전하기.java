import java.util.*;

class Solution {

    public int rotate(int[] query, int[][] arr) {
        // x1, x2 y1, y2 -> x1, y1 y1+1 ~ x1,y2
        int x1 = query[0], y1 = query[1], x2 = query[2], y2 = query[3];
        int prev = arr[x1][y1];
        int min = prev;
        for (int i = y1 + 1; i <= y2; i++) {
            int tmp = arr[x1][i];
            arr[x1][i] = prev;
            prev = tmp;
            min = Math.min(min, prev);
        }
        for (int i = x1 + 1; i <= x2; i++) {
            int tmp = arr[i][y2];
            arr[i][y2] = prev;
            prev = tmp;
            min = Math.min(min, prev);
        }
        for (int i = y2 - 1; i >= y1; i--) {
            int tmp = arr[x2][i];
            arr[x2][i] = prev;
            prev = tmp;
            min = Math.min(min, prev);
        }
        for (int i = x2 - 1; i >= x1; i--) {
            int tmp = arr[i][y1];
            arr[i][y1] = prev;
            prev = tmp;
            min = Math.min(min, prev);
        }
        return min;
    }

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] arr = new int[rows + 1][columns + 1];
        int num = 1;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                arr[i][j] = num++;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            answer[i] = rotate(queries[i], arr);
        }
        
        return answer;
    }
}