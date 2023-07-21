import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// BOJ3190.뱀(골드4)
// 먼저 뱀은 몸길이를 늘려 머리를 다음칸에 위치시킨다.
// 만약 벽이나 자기자신의 몸과 부딪히면 게임이 끝난다.
// 만약 이동한 칸에 사과가 있다면, 그 칸에 있던 사과가 없어지고 꼬리는 움직이지 않는다.
// 만약 이동한 칸에 사과가 없다면, 몸길이를 줄여서 꼬리가 위치한 칸을 비워준다. 즉, 몸길이는 변하지 않는다.
// 시작하고 X초후 L : 왼쪽으로 90도 회전, R : 오른쪽으로 90도 회전 , X가 증가하는 순으로 입력 주어짐.
// 벽 또는 자기자신의 몸과 부딪히면 게임이 끝난다.
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N + 1][N + 1];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			arr[row][col] = 1;
		}
		st = new StringTokenizer(br.readLine());
		HashMap<Integer, String> map = new HashMap<>();
		int L = Integer.parseInt(st.nextToken());
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int sec = Integer.parseInt(st.nextToken());
			String dir = st.nextToken();
			map.put(sec, dir);
		}

		// 초기값
		boolean[][] isVisit = new boolean[N + 1][N + 1]; // 뱀의 몸인지
		Deque<Integer> que = new ArrayDeque<>();
		int x = 1, y = 2, sec = 0, direction = 0; // 오=0, 아래=1, 왼=2, 위=3
		que.offer(1);
		que.offer(1);
		// 게임 start
		while (++sec > 0 && x >= 1 && x <= N && y >= 1 && y <= N && !isVisit[x][y]) {
			// 체크
			que.offer(x);
			que.offer(y);
			isVisit[x][y] = true;
			if (arr[x][y] == 1) // 만약 이동한 칸에 사과가 있다면, 그 칸에 있던 사과가 없어지고 꼬리는 움직이지 않는다.
				arr[x][y] = 0;
			else // 만약 이동한 칸에 사과가 없다면, 몸길이를 줄여서 꼬리가 위치한 칸을 비워준다. 즉, 몸길이는 변하지 않는다.
				isVisit[que.poll()][que.poll()] = false;

			// 다음 갈 방향 정하기
			if (map.containsKey(sec)) {
				if (map.get(sec).equals("L"))
					direction += 3;
				if (map.get(sec).equals("D"))
					direction++;
				direction %= 4;
			}

			// 감
			if (direction == 0)
				y += 1; // 오
			else if (direction == 1)
				x += 1; // 아래
			else if (direction == 2)
				y -= 1; // 왼
			else if (direction == 3)
				x -= 1; // 위
		}
		System.out.println(sec);
	}//

}//
