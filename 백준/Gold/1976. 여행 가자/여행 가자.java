import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] info;

	static int find(int v) {
		if (info[v] == v)
			return v;
		else
			return info[v] = find(info[v]);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int[][] city = new int[N + 1][N + 1];
		info = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= N; i++)
			info[i] = i;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
				if (city[i][j] == 1) {
					int pari = find(i);
					int parj = find(j);
					if (pari > parj)
						info[pari] = parj;
					else
						info[parj] = pari;
				}
			}
		}
		boolean flag = false;
		st = new StringTokenizer(br.readLine());
		int[] plan = new int[M];
		for (int i = 0; i < M; i++)
			plan[i] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < M; i++) {
			if (info[plan[i - 1]] != info[plan[i]]) {
				flag = true;
				break;
			}
		}
		if (flag)
			System.out.println("NO");
		else
			System.out.println("YES");

	}//

}//
