import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 문자	의미
.	평지(전차가 들어갈 수 있다.)
*	벽돌로 만들어진 벽
#	강철로 만들어진 벽
-	물(전차는 들어갈 수 없다.)
^	위쪽을 바라보는 전차(아래는 평지이다.)
v	아래쪽을 바라보는 전차(아래는 평지이다.)
<	왼쪽을 바라보는 전차(아래는 평지이다.)
>	오른쪽을 바라보는 전차(아래는 평지이다.)

문자	동작
U	Up : 전차가 바라보는 방향을 위쪽으로 바꾸고, 한 칸 위의 칸이 평지라면 위 그 칸으로 이동한다.
D	Down : 전차가 바라보는 방향을 아래쪽으로 바꾸고, 한 칸 아래의 칸이 평지라면 그 칸으로 이동한다.
L	Left : 전차가 바라보는 방향을 왼쪽으로 바꾸고, 한 칸 왼쪽의 칸이 평지라면 그 칸으로 이동한다.
R	Right : 전차가 바라보는 방향을 오른쪽으로 바꾸고, 한 칸 오른쪽의 칸이 평지라면 그 칸으로 이동한다.
S	Shoot : 전차가 현재 바라보고 있는 방향으로 포탄을 발사한다.

전차가 포탄을 발사하면,
포탄은 벽돌로 만들어진 벽 또는 강철로 만들어진 벽에 충돌하거나 게임 맵 밖으로 나갈 때까지 직진한다.

만약 포탄이 부딪힌 벽이 벽돌로 만들어진 벽이라면 이 벽은 파괴되어 칸은 평지가 된다.
강철로 만들어진 벽에 포탄이 부딪히면 아무 일도 일어나지 않는다.

게임 맵 밖으로 포탄이 나가면 아무런 일도 일어나지 않는다.

초기 게임 맵의 상태와 사용자가 넣을 입력이 순서대로 주어질 때,
모든 입력을 처리하고 나면 게임 맵의 상태가 어떻게 되는지 구하는 프로그램을 작성하라.
 */
public class Solution {

	static char[][] map;
	static int H, W;
	static int[] dx = { -1, 1, 0, 0 }; // 상 하 좌 우
	static int[] dy = { 0, 0, -1, 1 }; // U D L R

	static int direction(char c) {
		if (c == '^')
			return 0;
		if (c == 'v')
			return 1;
		if (c == '<')
			return 2;
		if (c == '>')
			return 3;
		return -1;
	}

	static void battlefield(int r, int c, String command) {
		int x = r, y = c;
		for (int i = 0; i < command.length(); i++) {
			char inst = command.charAt(i);
			if (inst == 'S') { // 전차가 현재 바라보고 있는 방향으로 포탄을 발사한다.
				int idx = direction(map[x][y]);
				int rx = x + dx[idx];
				int ry = y + dy[idx];
				while (rx >= 0 && rx < H && ry >= 0 && ry < W && map[rx][ry] != '#') {
					if (map[rx][ry] == '*') {
						map[rx][ry] = '.';
						break;
					}
					rx += dx[idx];
					ry += dy[idx];
				}
			} else if (inst == 'D') { // 전차가 바라보는 방향을 아래쪽으로 바꾸고
				if (x + 1 < H && map[x + 1][y] == '.') // 한 칸 아래의 칸이 평지라면 그 칸으로 이동한다.
				{
					map[x][y] = '.';
					map[++x][y] = 'v';
				} else
					map[x][y] = 'v';

			} else if (inst == 'U') { // 전차가 바라보는 방향을 위쪽으로 바꾸고
				if (x - 1 >= 0 && map[x - 1][y] == '.') // 한 칸 위의 칸이 평지라면 위 그 칸으로 이동한다.
				{
					map[x][y] = '.';
					map[--x][y] = '^';
				} else
					map[x][y] = '^';
			} else if (inst == 'L') { // 전차가 바라보는 방향을 왼쪽으로 바꾸고
				if (y - 1 >= 0 && map[x][y - 1] == '.') // 한 칸 왼쪽의 칸이 평지라면 그 칸으로 이동한다.
				{
					map[x][y] = '.';
					map[x][--y] = '<';
				} else
					map[x][y] = '<';
			} else if (inst == 'R') { // 전차가 바라보는 방향을 오른쪽으로 바꾸고
				if (y + 1 < W && map[x][y + 1] == '.') // 한 칸 오른쪽의 칸이 평지라면 그 칸으로 이동한다.
				{
					map[x][y] = '.';
					map[x][++y] = '>';
				} else
				{
					map[x][y] = '>';
				}
			}
		

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T=Integer.parseInt(st.nextToken());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];
			int r = 0, c = 0;
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				String str = st.nextToken();
				for (int j = 0; j < W; j++) {
					map[i][j] = str.charAt(j);
					if (map[i][j] == '<' || map[i][j] == '>' || map[i][j] == '^' || map[i][j] == 'v') {
						r = i;
						c = j;
					}
				}

			}
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			battlefield(r, c, command);
			System.out.print("#" + t + " ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}

	}//

}//