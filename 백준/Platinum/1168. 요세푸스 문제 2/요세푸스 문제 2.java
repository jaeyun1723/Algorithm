import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int[] seg;

	static int init(int start, int end, int node) {
		if (start == end)
			return seg[node] = 1;
		int mid = (start + end) / 2;
		return seg[node] = init(start, mid, 2 * node) + init(mid + 1, end, 2 * node + 1);

	}

	static int query(int start, int end, int node, int index) {
		if (start == end)
			return start;
		int mid = (start + end) / 2;
		if (index <= seg[2 * node])
			return query(start, mid, 2 * node, index);
		else
			return query(mid + 1, end, 2 * node + 1, index - seg[2 * node]);
	}

	static int update(int start, int end, int node, int num) {
		seg[node]--;
		if (start == end)
			return 0;
		else {
			int mid = (start + end) / 2;
			if (num <= mid)
				return update(start, mid, 2 * node, num);
			else
				return update(mid + 1, end, 2 * node + 1, num);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken()) - 1;

		seg = new int[4 * N];
		init(1, N, 1);
		int index = 1;
		StringBuilder sb = new StringBuilder("<");
		for (int i = 0; i < N; i++) {
			index += K;
			int size = N - i;
			if (index % size == 0)
				index = size;
			if (index > size) {
				index %= size;
			}

			int num = query(1, N, 1, index);
			if (i == N - 1)
				sb.append(num + ">");
			else
				sb.append(num + ", ");
			update(1, N, 1, num);
		}
		System.out.println(sb.toString() + "\n");
	}
}
