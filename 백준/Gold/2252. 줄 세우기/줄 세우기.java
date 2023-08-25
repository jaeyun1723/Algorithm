import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		int[] inDegree = new int[N + 1];
		for (int i = 0; i <= N; i++)
			list.add(new ArrayList<Integer>());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list.get(from).add(to);
			inDegree[to]++;
		}
		StringBuilder sb = new StringBuilder();
		Deque<Integer> deq = new ArrayDeque<Integer>();

		for (int i = 1; i < list.size(); i++)
			if (inDegree[i] == 0)
				deq.offerLast(i);

		while (!deq.isEmpty()) {
			int node = deq.pollFirst();
			sb.append(node).append(" ");
			for (int i = 0; i < list.get(node).size(); i++) {
				if (--inDegree[list.get(node).get(i)] == 0)
					deq.offer(list.get(node).get(i));
			}
		}
		System.out.println(sb);
	}
}