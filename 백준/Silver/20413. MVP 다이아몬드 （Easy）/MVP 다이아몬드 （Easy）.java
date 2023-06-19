
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] grade = new int[5];
		for (int i = 1; i < 5; i++)
			grade[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		String record = st.nextToken();
		int prev = 0;
		if (record.charAt(0) == 'B')
			prev = grade[1] - 1;
		else if (record.charAt(0) == 'S')
			prev = grade[2] - 1;
		else if (record.charAt(0) == 'G')
			prev = grade[3] - 1;
		else if (record.charAt(0) == 'P')
			prev = grade[4] - 1;
		else
			prev = grade[4];
		int sum = prev;
		int now = 0;
		for (int i = 1; i < record.length(); i++) {
			if (record.charAt(i) == 'B') {
				now = grade[1] - 1 - prev;
			} else if (record.charAt(i) == 'S') {
				now = grade[2] - 1 - prev;
			} else if (record.charAt(i) == 'G') {
				now = grade[3] - 1 - prev;
			} else if (record.charAt(i) == 'P') {
				now = grade[4] - 1 - prev;
			} else
				now = grade[4];
			prev = now;
			sum += now;
		}
		System.out.println(sum);
//		b   s  g  p	
//		0  30 60  90	
//		29 30 30
//		b  s  g
	}

}
