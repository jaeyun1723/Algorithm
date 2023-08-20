import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
1. 문제
- 세로 R칸, 가로 C칸으로 된 표 모양의 보드가 있다.

- 보드의 각 칸에는 대문자 알파벳이 하나씩 적혀 있고
  좌측 상단 칸 (1행 1열) 에는 말이 놓여 있다.

- 말은 상하좌우로 인접한 네 칸 중의 한 칸으로 이동할 수 있는데,
  좌측 상단에서 시작해서, 말이 최대한 몇 칸을 지날 수 있는지를 구하는 프로그램을 작성하시오.

- 말이 지나는 칸은 좌측 상단의 칸도 포함된다.
2. 전략
- DFS이용
3. 제약
- 새로 이동한 칸에 적혀 있는 알파벳은
  지금까지 지나온 모든 칸에 적혀 있는 알파벳과는 달라야 한다.

- 같은 알파벳이 적힌 칸을 두 번 지날 수 없다.



 */
public class Main {

    static int R, C, answer;
    static char[][] board;
    static boolean[] alphabet;
    static int[] dx = {-1, 1, 0, 0}; // 상 하 좌 우
    static int[] dy = {0, 0, -1, 1};

    static void dfs(int r, int c, int cnt) {
        answer = Math.max(answer, cnt);

        for (int i = 0; i < 4; i++) {
            int x = r + dx[i];
            int y = c + dy[i];
            if (x < 0 || x >= R || y < 0 || y >= C || alphabet[board[x][y] - 'A']) {
                continue;
            }
            alphabet[board[x][y] - 'A'] = true;
            dfs(x, y, cnt + 1);
            alphabet[board[x][y] - 'A'] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        alphabet = new boolean[26];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j = 0; j < C; j++) {
                board[i][j] = str.charAt(j);
            }
        }
        alphabet[board[0][0]-'A'] = true;
        dfs(0, 0, 1);
        System.out.println(answer);
    }//

}//