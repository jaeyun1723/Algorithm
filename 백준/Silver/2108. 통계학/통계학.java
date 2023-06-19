
import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		Map<Integer, Integer> map = new HashMap<>();
		int[] arr = new int[N];
		int sum = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			map.put(num, map.getOrDefault(num, 0) + 1);
			arr[i] = num;
			sum += num;
		}

		Arrays.sort(arr);
		List<Integer> list = new ArrayList<>(map.values());
		Collections.sort(list, Collections.reverseOrder());
		int most = list.get(0);
		list.clear();
		for (Entry<Integer, Integer> entry : map.entrySet())
			if (most == entry.getValue())
				list.add(entry.getKey());
		Collections.sort(list);
		if (list.size() >= 2)
			most = list.get(1);
		else
			most = list.get(0);
		System.out.println(Math.round(sum / (double) N));
		System.out.println(arr[N / 2]);
		System.out.println(most);
		System.out.println(arr[N - 1] - arr[0]);
	}

}
