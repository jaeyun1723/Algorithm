import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] arr = new int[31][31];

	static int comb(int n, int k) {
		if (n == k || k == 0)
			return 1;
		if (arr[n][k] > 0)
			return arr[n][k];
		return arr[n][k] = comb(n - 1, k) + comb(n - 1, k - 1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			System.out.println(comb(M, N));

		}
		
	}

}