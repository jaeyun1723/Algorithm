import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int r, c;

	static boolean isWin(int x, int y) {
		int ix1, ix2, iy1, iy2, cnt = -1;
		ix1 = ix2 = x;
		iy1 = iy2 = y;
		// 1. '/'방향
		// (왼아래->오위)
		while (ix1 >= 1 && ix1 <= 19 && iy1 >= 1 && iy1 <= 19 && (arr[ix1][iy1] == arr[x][y])) {
			cnt++;
			ix1--;
			iy1++;
		}
		// (오위->왼아래)
		while (ix2 >= 1 && ix2 <= 19 && iy2 >= 1 && iy2 <= 19 && (arr[ix2][iy2] == arr[x][y])) {
			cnt++;
			ix2++;
			iy2--;
		}
		if (cnt == 5) {
			r = --ix2;
			c = ++iy2;
			return true;
		}

		// 2. '-'방향(왼쪽)
		ix1 = ix2 = x;
		iy1 = iy2 = y;
		cnt = -1;
		while (ix1 >= 1 && ix1 <= 19 && iy1 >= 1 && iy1 <= 19 && (arr[ix1][iy1] == arr[x][y])) {
			cnt++;
			iy1--;
		}
		// '-'방향(오른쪽)
		while (ix2 >= 1 && ix2 <= 19 && iy2 >= 1 && iy2 <= 19 && (arr[ix2][iy2] == arr[x][y])) {
			cnt++;
			iy2++;
		}
		if (cnt == 5) {
			r = ix1;
			c = ++iy1;
			return true;
		}

		// 3. '\'방향(왼위->오아래)
		ix1 = ix2 = x;
		iy1 = iy2 = y;
		cnt = -1;
		while (ix1 >= 1 && ix1 <= 19 && iy1 >= 1 && iy1 <= 19 && (arr[ix1][iy1] == arr[x][y])) {
			cnt++;
			ix1++;
			iy1++;
		}
		// (오아래->왼위)
		while (ix2 >= 1 && ix2 <= 19 && iy2 >= 1 && iy2 <= 19 && (arr[ix2][iy2] == arr[x][y])) {
			cnt++;
			ix2--;
			iy2--;
		}
		if (cnt == 5) {
			r = ++ix2;
			c = ++iy2;
			return true;
		}

		// 4. '|'방향 (아래)
		ix1 = ix2 = x;
		iy1 = iy2 = y;
		cnt = -1;
		while (ix1 >= 1 && ix1 <= 19 && iy1 >= 1 && iy1 <= 19 && (arr[ix1][iy1] == arr[x][y])) {
			cnt++;
			ix1++;
		}
		// 위
		while (ix2 >= 1 && ix2 <= 19 && iy2 >= 1 && iy2 <= 19 && (arr[ix2][iy2] == arr[x][y])) {
			cnt++;
			ix2--;
		}
		if (cnt == 5) {
			r = ++ix2;
			c = iy2;
			return true;
		}

		return false;

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		arr = new int[20][20];

		for (int i = 1; i <= 19; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 19; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= 19; i++)
			for (int j = 1; j <= 19; j++) {
				if (arr[i][j] != 0 && isWin(i, j)) {
					System.out.println(arr[i][j]);
					System.out.println(r + " " + c);
					return;
				}
			}
		System.out.println(0);

	}
}