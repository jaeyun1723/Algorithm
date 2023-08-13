import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] arr, dwarf;

	public static void isDwarf(int idx, int cnt) {
		if (cnt == 7) {
			int sum = 0;
			for (int i : dwarf)
				sum += i;
			if (sum == 100) {
				for (int i : dwarf)
					System.out.println(i);
			}
			return;
		}
		for (int i = idx; i < 9; i++) {
			dwarf[cnt] = arr[i];
			isDwarf(i + 1, cnt + 1);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		arr = new int[9];
		dwarf = new int[7];
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}
		isDwarf(0, 0);
	}

}