class Solution {

    static int[][] map;

    public int rotate(int[] query) {
        int x1 = query[0];
        int y1 = query[1];
        int x2 = query[2];
        int y2 = query[3];

        // 시작점의 값 임시 저장
        int temp = map[x1][y1];

        int min = temp;
        for (int i = x1; i < x2; i++) {
            map[i][y1] = map[i + 1][y1];
            min = Math.min(min, map[i][y1]);
        }

        for (int j = y1; j < y2; j++) {
            map[x2][j] = map[x2][j + 1];
            min = Math.min(min, map[x2][j]);
        }
        for (int i = x2; i > x1; i--) {
            map[i][y2] = map[i - 1][y2];
            min = Math.min(min, map[i][y2]);
        }
        for (int j = y2; j > y1; j--) {
            map[x1][j] = map[x1][j - 1];
            min = Math.min(min, map[x1][j]);
        }
        map[x1][y1 + 1] = temp;

        return min;
    }

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        map = new int[rows + 1][columns + 1];
        int num = 1;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                map[i][j] = num++;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            answer[i] = rotate(queries[i]);
        }

        return answer;
    }
}