
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		Queue<Integer> que = new LinkedList<>();
		for (int i = 1; i <= N; i++)
			que.add(i);
		if (N == 1)
			System.out.println(que.peek());
		else {
			while (!que.isEmpty()) {
				que.remove();
				que.add(que.remove());
				if (que.size() == 1) {
					System.out.println(que.peek());
					return;
				}
			}
		}
	}

}
