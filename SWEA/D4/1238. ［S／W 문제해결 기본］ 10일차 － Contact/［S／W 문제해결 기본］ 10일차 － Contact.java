import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {

	static class Person {
		int info;
		int depth;

		Person(int info, int depth) {
			this.info = info;
			this.depth = depth;
		}

	}

	static ArrayList<ArrayList<Integer>> contact;
	static boolean[] isVisit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int t = 1; t <= 10; t++) {
			st = new StringTokenizer(br.readLine());
			int len = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			isVisit = new boolean[101];
			contact = new ArrayList<>();
			for (int i = 0; i < 101; i++)
				contact.add(new ArrayList<Integer>());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < len / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				contact.get(from).add(to);
			}
			Person answer = new Person(0, 0);
			Deque<Person> deq = new ArrayDeque<>();
			deq.offerLast(new Person(start, 0));
			isVisit[start] = true;
			while (!deq.isEmpty()) {
				Person now = deq.pollFirst();
				if (now.depth > answer.depth)
					answer = now;
				if (now.depth == answer.depth)
					answer.info = Math.max(answer.info, now.info);
				for (int i = 0; i < contact.get(now.info).size(); i++) {
					int next = contact.get(now.info).get(i);
					if (!isVisit[next]) {
						isVisit[next] = true;
						deq.offerLast(new Person(next, now.depth + 1));
					}
				}
			}

			System.out.println("#" + t + " " + answer.info);

		}

	}//

}//