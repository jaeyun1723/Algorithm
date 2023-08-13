import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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

	static ArrayList<Point> chicken, house;
	static boolean[] isOpen;
	static int N, M, min;

	public static class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void dfs(int cnt, int idx) {
		if (cnt == M) {
			int tDist = 0;
			for (int i = 0; i < house.size(); i++) {
				int cDist = Integer.MAX_VALUE;
				for (int j = 0; j < chicken.size(); j++) {
					if (isOpen[j]) {
						int dist = Math.abs(house.get(i).x - chicken.get(j).x)
								+ Math.abs(house.get(i).y - chicken.get(j).y);
						cDist = Math.min(cDist, dist); // 최솟값, 가장 가까운 치킨거리
					}
				}
				tDist += cDist;
			}
			min = Math.min(tDist, min);
			return;
		}

		for (int i = idx; i < chicken.size(); i++) {
			if (isOpen[i] == false) {
				isOpen[i] = true;
				dfs(cnt + 1, i + 1);
				isOpen[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		chicken = new ArrayList<>();
		house = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 1)
					house.add(new Point(i, j));
				else if (num == 2)
					chicken.add(new Point(i, j));
			}
		}
		isOpen = new boolean[chicken.size()];
		min = Integer.MAX_VALUE;
		dfs(0, 0);
		System.out.println(min);
	}

}