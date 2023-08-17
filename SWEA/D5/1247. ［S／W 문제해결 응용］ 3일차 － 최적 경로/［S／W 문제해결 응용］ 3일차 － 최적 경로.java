import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

	static int[][] customer;
	static int[] company, home, route;
	static boolean[] isVisit;
	static int N, tDist;

	static int distance(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}

	static void shortestRoute(int cnt) {
		if (cnt == N) {
			int sum = distance(company[0], company[1], customer[route[0]][0], customer[route[0]][1]);
			for (int i = 1; i < N; i++)
				sum += distance(customer[route[i - 1]][0], customer[route[i - 1]][1], customer[route[i]][0],
						customer[route[i]][1]);
			sum += distance(customer[route[N - 1]][0], customer[route[N - 1]][1], home[0], home[1]);
			tDist = Math.min(tDist, sum);
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!isVisit[i]) {
				isVisit[i] = true;
				route[cnt] = i;
				shortestRoute(cnt + 1);
				isVisit[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			company = new int[2];
			home = new int[2];
			customer = new int[N][2];
			isVisit = new boolean[N];
			for (int i = 0; i < 2; i++)
				company[i] = Integer.parseInt(st.nextToken());
			for (int i = 0; i < 2; i++)
				home[i] = Integer.parseInt(st.nextToken());
			for (int i = 0; i < N; i++) {
				customer[i][0] = Integer.parseInt(st.nextToken());
				customer[i][1] = Integer.parseInt(st.nextToken());
			}
			tDist = Integer.MAX_VALUE;
			route = new int[N];
			shortestRoute(0);
			System.out.println("#" + t +" "+ tDist);
		}

	}//

}//