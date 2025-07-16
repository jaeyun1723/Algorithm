class Solution {

    static int answer = 0;

    public void maxDungeons(int now, int clear, int[][] dungeons, boolean[] dungeon) {
        for (int i = 0; i < dungeons.length; i++) {
            if (!dungeon[i] && now >= dungeons[i][0]) {
                dungeon[i] = true;
                maxDungeons(now - dungeons[i][1], clear + 1, dungeons, dungeon);
                dungeon[i] = false;
            }
        }
        answer = Math.max(answer, clear);
        return;
    }


    public int solution(int k, int[][] dungeons) {
        maxDungeons(k, 0, dungeons, new boolean[dungeons.length]);
        return answer;
    }
}