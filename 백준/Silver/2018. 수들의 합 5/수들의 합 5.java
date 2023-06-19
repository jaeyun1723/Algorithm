
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 수들의 합(실버5)
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int sum = 0;
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			int k = i;
			sum = 0;
			while (sum < N) {
				sum += k;
				k++;
			}
			if (sum == N)
				cnt++;
		}
		System.out.println(cnt);
		
	}

}
