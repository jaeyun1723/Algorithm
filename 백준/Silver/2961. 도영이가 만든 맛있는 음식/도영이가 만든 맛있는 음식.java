import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 *  신맛 : 곱 , 쓴맛 : 합
 */
public class Main {

	static int N, diff;
	static int[][] ingredient;
	static boolean[] isSelected;

	static void cook(int idx, int sour, int bitter, int cnt) {
		diff = Math.min(diff, (cnt == 0) ? Integer.MAX_VALUE : Math.abs(sour - bitter));
		if (idx == N)
			return;
		cook(idx + 1, sour * ingredient[idx][0], bitter + ingredient[idx][1], cnt + 1);
		cook(idx + 1, sour, bitter, cnt);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		ingredient = new int[N][2];
		isSelected = new boolean[N];
		diff = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int sour = Integer.parseInt(st.nextToken());
			int bitter = Integer.parseInt(st.nextToken());
			ingredient[i][0] = sour;
			ingredient[i][1] = bitter;
		}
		cook(0, 1, 0, 0);
		System.out.println(diff);
	}

}