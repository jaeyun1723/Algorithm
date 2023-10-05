import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static final int INF = 9999;
	static int[][] map;
	static boolean[][] isVisit;
	static int N, M, ans;
	static ArrayList<ArrayList<int[]>> island;
	static PriorityQueue<int[]> pq;
	static int[] parent, dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };

	public static ArrayList<int[]> bfs(int x, int y) {
		ArrayList<int[]> list = new ArrayList<int[]>();
		list.add(new int[] { x, y });
		Deque<int[]> deq = new ArrayDeque<int[]>();
		deq.add(new int[] { x, y });
		isVisit[x][y] = true;
		while (!deq.isEmpty()) {
			int[] now = deq.pollFirst();
			for (int i = 0; i < 4; i++) {
				int nx = now[0] + dx[i], ny = now[1] + dy[i];
				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;
				if (isVisit[nx][ny] || map[nx][ny] == 0)
					continue;
				isVisit[nx][ny] = true;
				deq.offerLast(new int[] { nx, ny });
				list.add(new int[] { nx, ny });
			}
		}

		return list;
	}

	public static boolean isBridge(int flag, int x1, int y1, int x2, int y2) {
		if (flag == 0) {
			int from = Math.min(y1, y2), to = Math.max(y1, y2);
			while (++from < to)
				if (map[x1][from] == 1)
					return false;
		} else {
			int from = Math.min(x1, x2), to = Math.max(x1, x2);
			while (++from < to)
				if (map[from][y1] == 1)
					return false;
		}
		return true;
	}

	public static int distance(int a, int b) {
	//	System.out.println("--------" + a + " : " + b + "--------");
		int dist = INF;
		ArrayList<int[]> la = island.get(a), lb = island.get(b);
		for (int i = 0; i < la.size(); i++) {
			for (int j = 0; j < lb.size(); j++) {
				int x1 = la.get(i)[0], y1 = la.get(i)[1], x2 = lb.get(j)[0], y2 = lb.get(j)[1];
				if ((x1 == x2 && isBridge(0, x1, y1, x2, y2)) || (y1 == y2 && isBridge(1, x1, y1, x2, y2))) {
					int bridge = Math.abs((x1 - x2) + (y1 - y2)) - 1;
	//				System.out.println(bridge);
					if (bridge >= 2)
						dist = Math.min(dist, bridge);
				}
			}
		}
		return dist;
	}

	public static int find(int i) {
		if (parent[i] == i)
			return i;
		return parent[i] = find(parent[i]);
	}

	public static void union(int i, int j) {
		int p1 = find(i), p2 = find(j);
		if (p1 < p2)
			parent[p1] = p2;
		else
			parent[p2] = p1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		isVisit = new boolean[N][M];
		island = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++)
				if (!isVisit[i][j] && map[i][j] == 1) {
					ArrayList<int[]> list = bfs(i, j);
					island.add(list);
				}
		}

		int size = island.size();
		parent = new int[size];
		pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});

		for (int i = 0; i < parent.length; i++)
			parent[i] = i;

		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++) {
				if (i == j)
					continue;
				// System.out.println("--------" + i + "," + j + "---------");
				int length = distance(i, j);
				// System.out.println(length);
				if (length != INF)
					pq.offer(new int[] { i, j, length });
				// System.out.println("-----------------");
			}
//		while (!pq.isEmpty()) {
//			int[] cur = pq.poll();
//			System.out.println("(" + cur[0] + " , " + cur[1] + " : " + cur[2] + ")");
//		}

		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			if (find(cur[0]) != find(cur[1])) {
//				System.out.println(find(cur[0])+" : "+find(cur[1]));
				union(cur[0], cur[1]);
				ans += cur[2];
			}
		}
		for (int i = 1; i < size; i++)
			if (find(i) != find(i - 1)) {
				System.out.println(-1);
				return;
			}
		System.out.println(ans);
	}//
}//