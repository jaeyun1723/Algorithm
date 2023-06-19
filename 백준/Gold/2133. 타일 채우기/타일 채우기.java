import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int[] dp = new int[31];
		dp[0] = 1;
		dp[2] = 3;
		// 짝 + 짝 = 짝
		for (int i = 4; i <= 30; i += 2) {
			dp[i] = 3 * dp[i - 2];
			for (int j = 0; j <= i - 4; j += 2)
				dp[i] += 2 * dp[j];
		}
		System.out.println(dp[N]);

	}// etc
}// etc
