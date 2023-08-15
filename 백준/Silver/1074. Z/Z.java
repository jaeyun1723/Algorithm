import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, r, c, answer;

	static void solve(int x, int y, int size) {
		if (size == 1) {
			System.out.println(answer);
			return;
		}
		int nSize = size / 2;
		if (r < x + nSize && c < y + nSize) {
			solve(x, y, nSize);
		}
		if (r < x + nSize && y + nSize <= c) {
			answer += (size * size) / 4;
			solve(x, y + nSize, nSize);
		}
		if (x + nSize <= r && c < y + nSize) {
			answer += ((size * size) / 4) * 2;
			solve(x + nSize, y, nSize);
		}
		if (x + nSize <= r && y + nSize <= c) {
			answer += ((size * size) / 4) * 3;
			solve(x + nSize, y + nSize, nSize);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		solve(0, 0, (int) Math.pow(2, N));

	}

}