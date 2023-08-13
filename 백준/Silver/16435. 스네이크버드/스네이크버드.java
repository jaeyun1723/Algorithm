import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 1. summary:
 과일 하나를 먹으면 길이가 1만큼 늘어납니다.
과일들은 지상으로부터 일정 높이를 두고 떨어져 있으며 i (1 ≤ i ≤ N) 번째 과일의 높이는 h입니다. 
자신의 길이보다 작거나 같은 높이에 있는 과일들을 먹을 수 있습니다.
스네이크버드의 처음 길이가 L일때 과일들을 먹어 늘릴 수 있는 최대 길이를 구하세요.
 * 2. strategy: 풀이전략
 * 	 
 * 	
 * 3. note: 주의할 사항(특이사항)
 * 	
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] feed = new int[N];
		for (int i = 0; i < N; i++)
			feed[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(feed);
		for (int i = 0; i < N; i++) {
			if (L < feed[i])
				break;
			L++;
		}
		System.out.println(L);
	}

}