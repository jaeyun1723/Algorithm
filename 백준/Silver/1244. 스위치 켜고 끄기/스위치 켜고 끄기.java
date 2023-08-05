import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] swit;
	static int[][] student;

	static void man(int snum) {
		int num = snum;
		while (snum <= N) {
			swit[snum] = 1 - swit[snum];
			snum += num;
		}
	}

	static void woman(int snum) {
		int idx = 0;
		while (swit[snum - idx] == swit[snum + idx]) {
			swit[snum - idx] = swit[snum + idx] = 1 - swit[snum - idx];
			idx++;
			if (snum - idx < 1 || snum + idx > N)
				break;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		swit = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++)
			swit[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int len = Integer.parseInt(st.nextToken());
		student = new int[len][2];
		for (int i = 0; i < len; i++) {
			st = new StringTokenizer(br.readLine());
			student[i][0] = Integer.parseInt(st.nextToken()); // 성별
			student[i][1] = Integer.parseInt(st.nextToken()); // 스위치 번호
		}
		
		for (int i = 0; i < len; i++) {
			if (student[i][0] == 1)
				man(student[i][1]);
			else
				woman(student[i][1]);
		
		}

		for (int i = 1; i <= N; i++) {
			if (i != 1 && i % 20 == 1)
				System.out.println();
			System.out.print(swit[i] + " ");
		}

	}

}
