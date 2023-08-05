
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int t = 1; t <= 10; t++) {
			st = new StringTokenizer(br.readLine());
			int dump = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			int[] arr = new int[101];
			int start = 101;
			int end = -1;
			for (int i = 0; i < 100; i++) {
				int num = Integer.parseInt(st.nextToken());
				start = Math.min(start, num);
				end = Math.max(end, num);
				arr[num]++;
			}

			while (dump-- > 0) {
				arr[start]--;
				arr[end]--;
				arr[end-1]++;
				arr[start + 1]++;
				if (arr[start] == 0)
					while (arr[start] == 0)
						start++;
				if (arr[end] == 0)
					while (arr[end] == 0)
						end--;
				if (start >= end)
					break;
			}
			
			System.out.println("#" + t + " " + (end - start));
		}

	}//

}//
