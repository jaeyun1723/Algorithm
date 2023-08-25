import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
/*
 * 1. summary:

 * 3. note: 주의할 사항(특이사항)
 * 	
 */

public class Main {

	static int N, d, k, c;
	static int[] belt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 접시 수
		d = Integer.parseInt(st.nextToken()); // 초밥 가짓수
		k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 개수
		c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

		belt = new int[N + k];
		Set<Integer> sushi = new HashSet<>();
		Map<Integer, Integer> eat = new HashMap<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			belt[i] = Integer.parseInt(st.nextToken());
			sushi.add(belt[i]);
			if (i < k)
				belt[N + i] = belt[i];
		}
		for (int i = 0; i < k; i++)
			eat.put(belt[i], eat.getOrDefault(belt[i], 0) + 1);
		int cnt = 0;
		for (int i = k; i < belt.length; i++) {
			eat.put(belt[i], eat.getOrDefault(belt[i], 0) + 1);
			if (eat.get(belt[i - k]) == 1)
				eat.remove(belt[i - k]);
			else
				eat.put(belt[i - k], eat.get(belt[i - k]) - 1);
			int kind = eat.size();
			if (!eat.containsKey(c))
				kind++;
			cnt = Math.max(cnt, kind);
		}
		System.out.println(cnt);

	}

}