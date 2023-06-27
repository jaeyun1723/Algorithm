import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Main {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> prime = new ArrayList<>();
		prime.add(2);
		for (int i = 3; i <= N; i++) {
			boolean isPrime = true;
			for (int j = 2; j <= (int) (Math.sqrt(i)); j++) {
				if (i % j == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				prime.add(i);
			}
		}
	
		int cnt = 0;
		for (int i = 0; i < prime.size(); i++) {
			if (prime.get(i) == N) {
				cnt++;
				continue;
			}
			int sum = prime.get(i);
			for (int j = i + 1; j < prime.size(); j++) {
				sum += prime.get(j);
				if (sum == N) {
					cnt++;
					break;
				}
				if (sum > N)
					break;
			}
		}
		System.out.println(cnt);
	}//
}//