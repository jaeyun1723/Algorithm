import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, white, blue;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		paper(0, N - 1, 0, N - 1);
		System.out.println(white);
		System.out.println(blue);
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(arr[i][j] + " ");
//			}
//			System.out.println();
//		}

	}//

	static void paper(int x1, int x2, int y1, int y2) {
		if (isSame(x1, x2, y1, y2))
			return;
		else {
			int x_mid = (x1 + x2) / 2;
			int y_mid = (y1 + y2) / 2;
			paper(x1, x_mid, y1, y_mid);
			paper(x_mid + 1, x2, y1, y_mid);
			paper(x1, x_mid, y_mid + 1, y2);
			paper(x_mid + 1, x2, y_mid + 1, y2);
		}
	}

	static boolean isSame(int x1, int x2, int y1, int y2) {
		int flag = arr[x1][y1];
		for (int i = x1; i <= x2; i++)
			for (int j = y1; j <= y2; j++)
				if (arr[i][j] != flag)
					return false;
		if (flag == 1)
			blue++;
		else
			white++;
		return true;
	}
}//
