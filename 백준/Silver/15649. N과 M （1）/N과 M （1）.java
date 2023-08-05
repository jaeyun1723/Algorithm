
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] num;
	static boolean[] isSelected;

	static void permutation(int cnt, int idx) {
		if (cnt == M) {
			for (int i : num)
				System.out.print(i + " ");
			System.out.println();
			return;
		}
		for (int i = 1; i <= N; i++) {
			if (isSelected[i])
				continue;
			num[cnt] = i;
			isSelected[i] = true;
			permutation(cnt + 1, i + 1);
			isSelected[i] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		num = new int[M];
		isSelected = new boolean[N + 1];
		permutation(0, 1);
	}

}
