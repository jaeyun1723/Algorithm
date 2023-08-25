import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static int N, answer = Integer.MAX_VALUE;
	static int[] population, set; // 인구수, 집합
	static ArrayList<Integer> section1, section2; // 선거구1,2
	static ArrayList<ArrayList<Integer>> area;

	static boolean isAdjacency(int start, ArrayList<Integer> section) {
		Deque<Integer> deq = new ArrayDeque<Integer>();
		boolean[] isVisit = new boolean[11];
		int cnt = 1;
		deq.add(start);
		isVisit[start] = true;
		while (!deq.isEmpty()) {
			ArrayList<Integer> list = area.get(deq.pollFirst());
			for (int i = 0; i < list.size(); i++) {
				if (!isVisit[list.get(i)] && section.contains(list.get(i))) {
					cnt++;
					isVisit[list.get(i)] = true;
					deq.offerLast(list.get(i));
				}
			}
		}
		if (cnt == section.size())
			return true;
		return false;
	}

	static void selectSection(int area) {
		if (area == N + 1) {
//			System.out.println("---------------");
//			for (int num : section1)
//				System.out.print(num + " ");
//			System.out.println();
//			for (int num : section2)
//				System.out.print(num + " ");
//			System.out.println();
//			System.out.println("---------------");
			if (section1.isEmpty() || section2.isEmpty())
				return;
			if (section1.size() < section2.size())
				return;
			// 1. 구역이 이어져있는지 확인
			if (isAdjacency(section1.get(0), section1) && isAdjacency(section2.get(0), section2)) {
				// 2. 인구 최소차이 구하기
				int pop1 = 0, pop2 = 0;
				for (int i = 0; i < section1.size(); i++)
					pop1 += population[section1.get(i)];
				for (int i = 0; i < section2.size(); i++)
					pop2 += population[section2.get(i)];
				answer = Math.min(answer, Math.abs(pop1 - pop2));
				return;
			}
			return;
		}
		section1.add(area);
		selectSection(area + 1);
		section1.remove(section1.size() - 1);
		section2.add(area);
		selectSection(area + 1);
		section2.remove(section2.size() - 1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		set = new int[N + 1];
		for (int i = 1; i <= N; i++)
			set[i] = i;

		population = new int[N + 1]; // 인구 수
		section1 = new ArrayList<Integer>(); // 선거구1
		section2 = new ArrayList<Integer>(); // 선거구2
		area = new ArrayList<>();
		for (int i = 0; i <= N; i++)
			area.add(new ArrayList<>());
		for (int i = 1; i <= N; i++)
			population[i] = Integer.parseInt(st.nextToken()); // 인구수 저장
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			for (int j = 0; j < cnt; j++)
				area.get(i).add(Integer.parseInt(st.nextToken()));
		}
		selectSection(1);
		if (answer == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(answer);

	}

}