import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] arr;
	static StringBuilder sb;

	static void QuadTree(int r, int c, int size) {
		if (size == 1) {
			sb.append(arr[r][c]);
			return;
		}
		boolean flag = true;
		for (int i = r; i < r + size; i++) {
			if (!flag)
				break;
			for (int j = c; j < c + size; j++) {
				if (arr[i][j] != arr[r][c]) {
					sb.append("(");
					flag = false;
					break;
				}
			}
		}
		if (flag)
			sb.append(arr[r][c]);
		else {
			QuadTree(r, c, size / 2);
			QuadTree(r, c + size / 2, size / 2);
			QuadTree(r + size / 2, c, size / 2);
			QuadTree(r + size / 2, c + size / 2, size / 2);
			sb.append(")");
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for (int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		QuadTree(0, 0, N);
		System.out.println(sb.toString());
	}

}