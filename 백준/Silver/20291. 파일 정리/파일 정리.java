
import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			String[] s = str.split("\\.");
			map.put(s[s.length-1], map.getOrDefault(s[s.length-1], 0) + 1);
		}
		List<String> list = new ArrayList<>(map.keySet());
		Collections.sort(list);
		for(String name : list) {
			System.out.println(name + " " + map.get(name));
		}
	}

}
