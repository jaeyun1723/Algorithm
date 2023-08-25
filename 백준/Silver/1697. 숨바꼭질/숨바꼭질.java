import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/*
 * 수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 
 * 동생은 점 K(0 ≤ K ≤ 100,000)에 있다.
 * 수빈이는 걷거나 순간이동을 할 수 있다.
 * 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다.
 * 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.
 * 수빈이와 동생의 위치가 주어졌을 때,
 * 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.
 */
public class Main {

	static int MAX_VALUE = 100_001;
	static boolean[] isVisit = new boolean[MAX_VALUE];

	static class Location {
		int loc;
		int second;

		Location(int loc, int second) {
			this.loc = loc;
			this.second = second;
		}
	}

	static int bfs(int start, int end) {
		Deque<Location> deq = new ArrayDeque<>();
		deq.offerLast(new Location(start, 0));
		isVisit[start] = true;
		while (!deq.isEmpty()) {
			Location now = deq.pollFirst();
			if (now.loc == end)
				return now.second;
			if (now.loc - 1 >= 0 && !isVisit[now.loc - 1]) {
				isVisit[now.loc - 1] = true;
				deq.offerLast(new Location(now.loc - 1, now.second + 1));
			}
			if (now.loc + 1 < MAX_VALUE && !isVisit[now.loc + 1]) {
				isVisit[now.loc + 1] = true;
				deq.offerLast(new Location(now.loc + 1, now.second + 1));
			}
			if (now.loc * 2 < MAX_VALUE && !isVisit[now.loc * 2]) {
				isVisit[now.loc * 2] = true;
				deq.offerLast(new Location(now.loc * 2, now.second + 1));
			}
		}
		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		System.out.println(bfs(N, K));
	}//
}//