import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			map.put(st.nextToken(), 1);
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String tmp = st.nextToken();
			map.put(tmp, map.getOrDefault(tmp, 0) + 1);
		}
		ArrayList<String> answer = new ArrayList<>();
		for (String key : map.keySet())
			if (map.get(key) > 1)
				answer.add(key);
		Collections.sort(answer);
		System.out.println(answer.size());
		for(String ans:answer)
			System.out.println(ans);
	}
}