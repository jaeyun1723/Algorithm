class Solution {

    static int answer = 0;

    public void game(int k, int[][] dungeons, int clear, boolean[] isVisited) {
        for (int i = 0; i < dungeons.length; i++) {
            if (isVisited[i]) {
                continue;
            }
            if (k >= dungeons[i][0]) {
                isVisited[i] = true;
                game(k - dungeons[i][1], dungeons, clear + 1, isVisited);
                isVisited[i] = false;
            }
        }
        answer = Math.max(answer, clear);
    }

    public int solution(int k, int[][] dungeons) {
        game(k, dungeons, 0, new boolean[dungeons.length]);
        return answer;
    }
}