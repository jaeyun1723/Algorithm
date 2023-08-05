import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 1. summary:
 
 * 2. strategy: 풀이전략
 * 	 
 * 	
 * 3. note: 주의할 사항(특이사항)
 * 	
 */

public class Main {

	static int[] need, pw;

	static int convert(char dna) {
		if (dna == 'A')
			return 0;
		if (dna == 'C')
			return 1;
		if (dna == 'G')
			return 2;
		if (dna == 'T')
			return 3;
		return -1;
	}

	static boolean isPassWord(int[] arr) {
		for (int i = 0; i < 4; i++)
			if (arr[i] < need[i])
				return false;
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		String str = st.nextToken();

		int[] dna = new int[4];
		need = new int[4];
		pw = new int[4];

		for (int i = 0; i < str.length(); i++) {
			int idx = convert(str.charAt(i));
			if (i < P)
				pw[idx]++;
			dna[idx]++;
		}
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < 4; i++)
			need[i] = Integer.parseInt(st.nextToken());

		for (int i = 0; i < 4; i++)
			if (dna[i] < need[i]) {
				System.out.println(0);
				return;
			}
		int cnt = 0;

		if (isPassWord(pw))
			cnt++;
		for (int i = 0; i < str.length() - P; i++) {
			pw[convert(str.charAt(i))]--;
			pw[convert(str.charAt(i + P))]++;
			if (isPassWord(pw))
				cnt++;

		}

		System.out.println(cnt);
	}

}