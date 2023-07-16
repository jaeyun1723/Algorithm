import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	static int[][] arr;
	static int N, M;

	static int plus(int x, int y) {
		int cnt = -arr[x][y];
		for (int i = -M + 1; i < M; i++) {
			if (x + i >= 0 && x + i < N)
				cnt += arr[x + i][y];
			if (y + i >= 0 && y + i < N)
				cnt += arr[x][y + i];
		}
		return cnt;
	}

	static int diag(int x, int y) {
		int cnt = -arr[x][y];
		for (int i = -M + 1; i < M; i++) {
			// 왼위->오아래
			if (x + i >= 0 && x + i < N && y + i >= 0 && y + i < N)
				cnt += arr[x + i][y + i];
			// 왼아래->오위
			if (x - i >= 0 && x - i < N && y + i >= 0 && y + i < N)
				cnt += arr[x - i][y + i];
		}
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= T; i++) {

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new int[N][N];
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < N; k++)
					arr[j][k] = Integer.parseInt(st.nextToken());
			}
			int max = 0;
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < N; y++) {
//					System.out.println("(" + x + "," + y + ") + >> " + plus(x, y));
//					System.out.println("(" + x + "," + y + ") x >> " + diag(x, y));
					max = Math.max(max, Math.max(plus(x, y), diag(x, y)));
				}
			}
			System.out.println("#" + i + " " + max);
//			for(int a=0;a<N;a++) {
//				System.out.println();
//				for(int j=0;j<N;j++)
//					System.out.print(arr[a][j]+" ");
//			}

		} //
	}//
}