import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		Stack<Integer> stk = new Stack<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int element = 1;
		int target = arr[0];
		StringBuilder sb = new StringBuilder();
		boolean flag = true;

		for (int i = 0; i < n; i++) {
			target = arr[i];
			if (element <= target) {
				while (element <= target) {
					stk.push(element++);
					sb.append("+").append("\n");
				}
			
			} else if (target != stk.peek()) {
				System.out.println("NO");
				return;
			}

			stk.pop();
			sb.append("-").append("\n");

		}
		System.out.println(sb.toString());

	} // etc

}// etc
