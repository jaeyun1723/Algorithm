import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			char prev = str.charAt(0);
			int cnt = prev == '1' ? 1 : 0;
			for (int i = 1; i < str.length(); i++) {
				if (str.charAt(i) != prev)
					cnt++;
				prev = str.charAt(i);
			}
		System.out.println("#" + t + " " + cnt);
		}

	}//

}//
