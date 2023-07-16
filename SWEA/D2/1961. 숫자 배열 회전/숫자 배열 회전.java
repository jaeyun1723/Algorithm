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
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++)
					arr[i][j] = Integer.parseInt(st.nextToken());
			}
			StringBuilder sb1 = new StringBuilder();
			StringBuilder sb2 = new StringBuilder();
			StringBuilder sb3 = new StringBuilder();
			for (int i = 0; i < N; i++)
				for (int j = N - 1; j >= 0; j--)
					sb1.append(arr[j][i]);

			for (int i = N - 1; i >= 0; i--)
				for (int j = N - 1; j >= 0; j--)
					sb2.append(arr[i][j]);

			for (int i = N - 1; i >= 0; i--)
				for (int j = 0; j < N; j++)
					sb3.append(arr[j][i]);
			
			System.out.println("#"+t);
			for(int i=0;i<N;i++) {
				StringBuilder sb = new StringBuilder();
					sb.append(sb1.substring(N*i, N*i+N)).append(" ");
					sb.append(sb2.substring(N*i, N*i+N)).append(" ");
					sb.append(sb3.substring(N*i, N*i+N)).append(" ");
					System.out.println(sb);				
			}

		} // test_case
	}// main
}// class
