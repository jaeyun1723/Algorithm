
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int N, diff = 100000001;
	static int[] S, B;
	static boolean[] isSelected;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		S = new int[N];
		B = new int[N];
		isSelected=new boolean[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			S[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
		}
		Cook(0);
		System.out.println(diff);
	}//

	static void Cook(int cnt) {
		if (cnt == N) {
			int sumS = 1;
			int sumB = 0;
			boolean flag = false;
			for (int i = 0; i < N; i++) {
				if (isSelected[i]) {
					sumS *= S[i];
					sumB += B[i];
					flag = true;
				}
			}
			if (flag) {
				int result = Math.abs(sumS - sumB);
				if (result < diff)
					diff = result;
			}
			return;
		}
		isSelected[cnt] = true;
		Cook(cnt + 1);
		isSelected[cnt] = false;
		Cook(cnt + 1);
	}

}
//
