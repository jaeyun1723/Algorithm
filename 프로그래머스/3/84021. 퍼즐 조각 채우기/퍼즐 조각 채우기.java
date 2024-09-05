import java.util.*;

class Solution {

    static List<List<Point>> tList = new ArrayList<>(); // table 블록
    static List<List<Point>> bList = new ArrayList<>(); // 빈 칸
    static int size, answer = 0;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

    public boolean isMatch(List<Point> table, List<Point> board) {
        Collections.sort(board);

        for (int i = 0; i < 4; i++) {
            Collections.sort(table);

            int curx = table.get(0).x;
            int cury = table.get(0).y;
            
            for (int j = 0; j < table.size(); j++) {
                table.get(j).x -= curx;
                table.get(j).y -= cury;
            }

            boolean flag = true;

            for (int j = 0; j < board.size(); j++) {
                if (board.get(j).x != table.get(j).x || board.get(j).y != table.get(j).y) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                return true;
            } else {
                for (int j = 0; j < table.size(); j++) {
                    int temp = table.get(j).x;
                    table.get(j).x = table.get(j).y;
                    table.get(j).y = -temp;
                }
            }
        }
        return false;
    }

    public void compareBlock(List<List<Point>> t, List<List<Point>> b) {
        int ts = t.size();
        int bs = b.size();

        boolean[] visited = new boolean[bs];
        for (int i = 0; i < ts; i++) {
            for (int j = 0; j < bs; j++) {
                if (visited[j] || t.get(i).size() != b.get(j).size()) {
                    continue;
                }
                if (isMatch(t.get(i), b.get(j))) {
                    visited[j] = true;
                    answer += b.get(j).size();
                    break;
                }
            }
        }
    }

    public static void bfs(int x, int y, int[][] map, boolean[][] visited, List<List<Point>> list) {
        Deque<Point> deq = new ArrayDeque<>();
        deq.offerLast(new Point(x, y));
        visited[x][y] = true;
        List<Point> sub = new ArrayList<>();
        sub.add(new Point(0, 0));

        while (!deq.isEmpty()) {
            Point now = deq.pollFirst();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= size || ny >= size) {
                    continue;
                }
                if (map[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    sub.add(new Point(nx - x, ny - y));
                    deq.offerLast(new Point(nx, ny));
                }
            }
        }
        list.add(sub);

    }

    public int solution(int[][] game_board, int[][] table) {
        size = game_board.length;
        boolean[][] isTable = new boolean[size][size];
        boolean[][] isBoard = new boolean[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (game_board[i][j] == 1) {
                    game_board[i][j] = 0;
                } else {
                    game_board[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (table[i][j] == 1 && !isTable[i][j]) {
                    bfs(i, j, table, isTable, tList);
                }
                if (game_board[i][j] == 1 && !isBoard[i][j]) {
                    bfs(i, j, game_board, isBoard, bList);
                }
            }
        }

        compareBlock(tList, bList);
        return answer;
    }

    static class Point implements Comparable<Point> {

        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int compareTo(Point o) {
            int res = Integer.compare(this.x, o.x);
            if (res == 0) {
                res = Integer.compare(this.y, o.y);
            }
            return res;
        }

    }
}