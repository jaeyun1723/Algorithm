import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int t = 1; t <= 10; t++) {
			st = new StringTokenizer(br.readLine());
			int len = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			Stack<Character> stk = new Stack<>();
			boolean flag = true;
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '{' || str.charAt(i) == '[' || str.charAt(i) == '(' || str.charAt(i) == '<')
					stk.push(str.charAt(i));
				else {
					if (stk.isEmpty()) {
						flag = false;
						break;
					}
					char temp = stk.pop();
					if (str.charAt(i) == '}' && temp != '{') {
						flag = false;
						break;
					} else if (str.charAt(i) == ']' && temp != '[') {
						flag = false;
						break;
					} else if (str.charAt(i) == ')' && temp != '(') {
						flag = false;
						break;
					} else if (str.charAt(i) == '>' && temp != '<') {
						flag = false;
						break;
					}
				}
			}
			if (stk.isEmpty() && flag)
				System.out.println("#" + t + " " + 1);
			else
				System.out.println("#" + t + " " + 0);

		}

	}//

}//