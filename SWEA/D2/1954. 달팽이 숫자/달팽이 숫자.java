import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[][] snail = new int[N + 1][N + 1];
			int num = 1;
			int r = 1, c = 1, dir = 1;
			while (num <= N * N) {
				snail[r][c] = num++;
				// 1. 전진 가능한지 아닌지 판단
				if (dir == 1) {// 오
					if (c + 1 <= N && snail[r][c + 1] == 0) // 전진 가능할때
						c++;
					else {
						dir = 2;
						r++;
					}
				} else if (dir == 2) { // 아래
					if (r + 1 <= N && snail[r + 1][c] == 0)
						r++;
					else {
						dir = 3;
						c--;
					}
				} else if (dir == 3) { // 왼
					if (c - 1 >= 1 && snail[r][c - 1] == 0)
						c--;
					else {
						dir = 4;
						r--;
					}
				} else { // 위
					if (r - 1 >= 1 && snail[r - 1][c] == 0)
						r--;
					else {
						dir = 1;
						c++;
					}
				}
			}
			System.out.println("#" + t);
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					System.out.print(snail[i][j] + " ");
				}
				System.out.println();
			}
		} //
	}

}