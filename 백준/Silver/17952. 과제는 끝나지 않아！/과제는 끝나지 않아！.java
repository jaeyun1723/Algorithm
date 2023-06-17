import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

	public static class proj {
		int score;
		int time;

		public proj(int score, int time) {
			this.score = score;
			this.time = time;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Deque<proj> deque = new ArrayDeque<>();

		int N = Integer.parseInt(st.nextToken());

		int sum = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			if (st.nextToken().equals("1")) {
				int score = Integer.parseInt(st.nextToken());
				int time = Integer.parseInt(st.nextToken()) - 1;
				if (time == 0)
					sum += score;
				else
					deque.addFirst(new proj(score, time));
			} else {
				if (deque.isEmpty())
					continue;
				if (--deque.peek().time == 0) {
					sum += deque.peek().score;
					deque.pollFirst();
				}
			}
		}
		System.out.println(sum);

	}// etc
}// etc
