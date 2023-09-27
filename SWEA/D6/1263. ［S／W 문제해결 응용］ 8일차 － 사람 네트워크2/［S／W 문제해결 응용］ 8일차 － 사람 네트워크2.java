import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[][] dist = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dist[i][j] = Integer.parseInt(st.nextToken());
					if (i != j && dist[i][j] == 0)
						dist[i][j] = 10000;
				}
			}

			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					if (k == i)
						continue;
					for (int j = 0; j < N; j++) {
						if (i == j || k == j)
							continue;
						if (dist[i][j] > dist[i][k] + dist[k][j])
							dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
			int ans = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				int sum = 0;
				for (int j = 0; j < N; j++) {
					if (i == j)
						continue;
					sum += dist[i][j];
				}
				ans = Math.min(ans, sum);
			}
			System.out.println("#" + t + " " + ans);
		}
	}

}