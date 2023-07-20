import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int[] a = new int[N];
			int[] b = new int[M];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				a[i] = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++)
				b[i] = Integer.parseInt(st.nextToken());

			Arrays.sort(a);
			Arrays.sort(b);

			int sum = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (a[i] > b[j])
						sum++;
					else
						break;
				}
			}

			System.out.println(sum);
		}
	}//

}//
