import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static class Log {
        int id;
        int qNum;
        int score;
        int time;

        public Log(int id, int qNum, int score, int time) {
            this.id = id;
            this.qNum = qNum;
            this.score = score;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 팀의 개수
            int k = Integer.parseInt(st.nextToken()); // 문제 개수
            int t = Integer.parseInt(st.nextToken()); // 나의 팀 ID
            int m = Integer.parseInt(st.nextToken()); // 로그 개수

            Log[] logs = new Log[m];
            int[][] team = new int[n + 1][4]; // (팀, 최종 점수, 제출 횟수, 마지막 제출 시간)
            for (int i = 0; i < team.length; i++) {
                team[i][0] = i;
            }
            boolean[][] solved = new boolean[n + 1][k + 1]; // (팀, 문제 번호)

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int id = Integer.parseInt(st.nextToken());
                int q = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                logs[i] = new Log(id, q, s, i);
                team[id][2]++;
                team[id][3] = i;
            }

            Arrays.sort(logs, (o1, o2) -> Integer.compare(o2.score, o1.score));

            for (int i = 0; i < logs.length; i++) {
                Log log = logs[i];
                if (!solved[log.id][log.qNum]) {
                    team[log.id][1] += log.score;
                    solved[log.id][log.qNum] = true;
                }
            }

            Arrays.sort(team, (o1, o2) -> {
                if (o1[1] == o2[1]) {
                    if (o1[2] == o2[2])
                        return Integer.compare(o1[3], o2[3]);
                    return Integer.compare(o1[2], o2[2]);
                }
                return Integer.compare(o2[1], o1[1]);
            });

            for (int i = 0; i < team.length; i++) {
                if (team[i][0] == t) {
                    System.out.println(i + 1);
                    break;
                }
            }
        }
    }
}