import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] value = new int[n];
		int[] dp = new int[k + 1];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			value[i] = Integer.parseInt(st.nextToken());
		//	 dp[value[i]] = 1;
		}
		Arrays.fill(dp, 100_001);
		dp[0] = 0;
		for (int i = 0; i < n; i++) {
			for (int j = value[i]; j <= k; j++) {
				dp[j] = Math.min(dp[j], dp[j - value[i]] + 1);
			}
		}
		if (dp[k] == 100_001)
			System.out.println(-1);
		else
			System.out.println(dp[k]);
	}

}
