import java.util.*;

class Solution {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static ArrayList<int[]> itvList(char[][] arr) {
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (arr[i][j] == 'P')
                    list.add(new int[]{i, j});
            }
        }
        return list;
    }

    public static char[][] toCharArr(String[] place) {
        char[][] arr = new char[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = place[i].charAt(j);
            }
        }
        return arr;
    }

    public static boolean isManhattan(int r1, int c1, int r2, int c2) {
        if (r1 == r2 && c1 == c2) return true;
        return Math.abs(r1 - r2) + Math.abs(c1 - c2) > 2;
    }

    public static boolean bfs(int[] start, char[][] arr) {
        boolean[][] isVisited = new boolean[5][5];
        ArrayDeque<int[]> deq = new ArrayDeque<>();
        deq.offerLast(start);
        isVisited[start[0]][start[1]] = true;

        while (!deq.isEmpty()) {
            int[] now = deq.pollFirst();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5 || arr[nx][ny] == 'X' || isVisited[nx][ny]) continue;
                if (arr[nx][ny] == 'P' && !isManhattan(start[0], start[1], nx, ny)) {
                    return false;
                }
                if (arr[nx][ny] == 'O' && !isManhattan(start[0], start[1], nx, ny)) {
                    deq.offerLast(new int[]{nx, ny});
                    isVisited[nx][ny] = true;
                }
            }
        }
        return true;
    }

    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        Arrays.fill(answer, -1);

        for (int i = 0; i < 5; i++) {
            char[][] arr = toCharArr(places[i]);
            ArrayList<int[]> list = itvList(arr);

            for (int j = 0; j < list.size(); j++) {
                if (!bfs(list.get(j), arr)) {
                    answer[i] = 0;
                    break;
                }
            }
            if (answer[i] == -1)
                answer[i] = 1;
        }

        return answer;
    }
}