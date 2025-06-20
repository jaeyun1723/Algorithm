class Solution {

    static int[][] map;

    public boolean canCompress(int x, int y, int len) {
        for (int i = x; i < x + len; i++) {
            for (int j = y; j < y + len; j++) {
                if (map[x][y] != map[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public void quadTree(int x, int y, int len, int[] answer) {
        if (len == 1) {
            answer[map[x][y]] += 1;
            return;
        }
        if (canCompress(x, y, len)) {
            answer[map[x][y]] += 1;
            return;
        }
        quadTree(x, y, len / 2, answer);
        quadTree(x, y + len / 2, len / 2, answer);
        quadTree(x + len / 2, y, len / 2, answer);
        quadTree(x + len / 2, y + len / 2, len / 2, answer);
    }

    public int[] solution(int[][] arr) {
        map = arr;
        int[] answer = new int[2];
        quadTree(0, 0, arr.length, answer);
        return answer;
    }
}