import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

/*
N×N크기의 땅이 있고, 땅은 1×1개의 칸으로 나누어져 있다.
각각의 땅에는 나라가 하나씩 존재하며, r행 c열에 있는 나라에는 A[r][c]명이 살고 있다.
인접한 나라 사이에는 국경선이 존재한다.
모든 나라는 1×1 크기이기 때문에, 모든 국경선은 정사각형 형태이다.
오늘부터 인구 이동이 시작되는 날이다.
인구 이동은 하루 동안 다음과 같이 진행되고,
더 이상 아래 방법에 의해 인구 이동이 없을 때까지 지속된다.

국경선을 공유하는 두 나라의 인구 차이가 L명 이상, R명 이하라면,
두 나라가 공유하는 국경선을 오늘 하루 동안 연다.
위의 조건에 의해 열어야하는 국경선이 모두 열렸다면, 인구 이동을 시작한다.
국경선이 열려있어 인접한 칸만을 이용해 이동할 수 있으면,
그 나라를 오늘 하루 동안은 연합이라고 한다.
연합을 이루고 있는 각 칸의 인구수는 (연합의 인구수) / (연합을 이루고 있는 칸의 개수)가 된다.
편의상 소수점은 버린다.
연합을 해체하고, 모든 국경선을 닫는다.
각 나라의 인구수가 주어졌을 때, 인구 이동이 며칠 동안 발생하는지 구하는 프로그램을 작성하시오
 */

public class Main {

    static int N, L, R, answer;
    static int[][] population;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static Deque<Point> checkList = new ArrayDeque<>();

    static void movePopulation(int r, int c, boolean[][] isMove) {
        // BFS 한번 하고
        isMove[r][c] = true;
        ArrayList<Point> list = new ArrayList<>();
        list.add(new Point(r, c));
        int sum = population[r][c];
        Deque<Point> deq = new ArrayDeque<>();
        deq.offer(new Point(r, c));
        while (!deq.isEmpty()) {
            Point now = deq.pollFirst();
            for (int i = 0; i < 4; i++) {
                int x = now.x + dx[i];
                int y = now.y + dy[i];
                if (!isAvailable(now.x, now.y, x, y) || isMove[x][y]) {
                    continue;
                }
                Point next = new Point(x, y);
                isMove[x][y] = true;
                sum += population[x][y];
                list.add(next);
                deq.offerLast(next);
            }
        }
        // 인구수 조정
        int cnt = sum / list.size();
        for (int i = 0; i < list.size(); i++) {
 //           System.out.print(list.get(i).x + "," + list.get(i).y + " ");
            population[list.get(i).x][list.get(i).y] = cnt;
        }
 //       System.out.println();
    }

    static boolean isAvailable(int r, int c, int nr, int nc) {
        if (r < 1 || c < 1 || nr < 1 || nc < 1 || r > N || c > N || nr > N || nc > N) {
            return false;
        }
        int diff = Math.abs(population[r][c] - population[nr][nc]);
        if (diff < L || diff > R) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        population = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                population[i][j] = Integer.parseInt(st.nextToken());
            }
        }
//        for (int a = 1; a <= N; a++) {
//            for (int b = 1; b <= N; b++) {
//                System.out.print(population[a][b] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println("=========================");
        Deque<Point> checkList = new ArrayDeque<>();
        boolean[][] isMove = new boolean[N + 1][N + 1];
        while (answer >= 0) {
            boolean day = false;
            isMove = new boolean[N + 1][N + 1];
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    for (int k = 0; k < 4; k++) {
                        if (!isMove[i][j] && isAvailable(i, j, i + dx[k], j + dy[k])) {
                            day = true;
//                            System.out.println("---------" + answer + "번째 날 -------------");
//                            System.out.println("시작 : " + i + "," + j);
                            movePopulation(i, j, isMove);
//                            for (int a = 1; a <= N; a++) {
//                                for (int b = 1; b <= N; b++) {
//                                    System.out.print(population[a][b] + " ");
//                                }
//                                System.out.println();
//                            }
//                            System.out.println("-------------------------------");
                        }
                    }
                }
            }
            if (day) {
                answer++;
            } else {
                break;
            }
        }
        System.out.println(answer);
    }

}