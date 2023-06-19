import java.util.*;

class Solution {

	public int solution(String s) {
		int answer = 0;
		int turn = s.length();
		StringBuilder sb = new StringBuilder();
		sb.append(s);
		while (--turn > 0) {
			Stack<Character> stk = new Stack<>();
			boolean flag = false;
			for (int i = 0; i < sb.length(); i++) {
				if (sb.charAt(i) == '[' || sb.charAt(i) == '{' || sb.charAt(i) == '(')
					stk.push(sb.charAt(i));
				else {
					if (stk.isEmpty()) {
						flag = true;
						break;
					}
					if (sb.charAt(i) == ']' && stk.peek() == '[')
						stk.pop();
					else if (sb.charAt(i) == '}' && stk.peek() == '{')
						stk.pop();
					else if (sb.charAt(i) == ')' && stk.peek() == '(')
						stk.pop();
					else {
						flag = true;
						break;
					}
				}
			}
			if (!flag&&stk.isEmpty())
				answer++;
			sb.append(sb.charAt(0));
			sb.deleteCharAt(0);
		}

		return answer;
	}
}