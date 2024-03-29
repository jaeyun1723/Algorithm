import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 외판원 순회 문제는 영어로 Traveling Salesman problem (TSP)
 * 1번부터 N번까지 번호가 매겨져 있는 도시들이 있고, 도시들 사이에는 길이 있다. (길이 없을 수도 있다)
 * 이제 한 외판원이 어느 한 도시에서 출발해 N개의 도시를 모두 거쳐 다시 원래의 도시로 돌아오는 순회 여행 경로를 계획하려고 한다.
 * 단, 한 번 갔던 도시로는 다시 갈 수 없다.(맨 마지막에 여행을 출발했던 도시로 돌아오는 것은 예외)
 * 이런 여행 경로는 여러 가지가 있을 수 있는데, 가장 적은 비용을 들이는 여행 계획을 세우고자 한다.
 * 각 도시간에 이동하는데 드는 비용은 행렬 W[i][j]형태로 주어진다.
 * W[i][j]는 도시 i에서 도시 j로 가기 위한 비용을 나타낸다.
 * 비용은 대칭적이지 않다.
 * 즉, W[i][j] 는 W[j][i]와 다를 수 있다.
 * 모든 도시간의 비용은 양의 정수이다.
 * W[i][i]는 항상 0이다.
 * 경우에 따라서 도시 i에서 도시 j로 갈 수 없는 경우도 있으며 이럴 경우 W[i][j]=0이라고 하자.
 * N과 비용 행렬이 주어졌을 때, 가장 적은 비용을 들이는 외판원의 순회 여행 경로를 구하는 프로그램을 작성하시오.
 */
public class Main {

	static int N;
	static int[][] tsp;
	static boolean[] isVisit;
	static int answer = Integer.MAX_VALUE;

	static void dfs(int start, int cnt, int sum, int city) {
		if (cnt == N) {
			if (tsp[start][city] != 0)
				answer = Math.min(answer, sum + tsp[start][city]);
			return;
		}
		for (int i = 0; i < N; i++) {
			if (isVisit[i] || tsp[start][i] == 0)
				continue;
			isVisit[i] = true;
			dfs(i, cnt + 1, sum + tsp[start][i], city);
			isVisit[i] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		tsp = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				tsp[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < N; i++) {
			isVisit = new boolean[N];
			isVisit[i] = true;
			dfs(i, 1, 0, i);
		}

		System.out.println(answer);
	}
}