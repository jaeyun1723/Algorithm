import java.util.*;

class Solution {

    static String[] priority = {"+-*", "+*-", "-+*", "-*+", "*+-", "*-+"};
    static ArrayList<Long> nums = new ArrayList<>();
    static ArrayList<Character> operators = new ArrayList<>();

    public static long calculate(long a, long b, char c) {
        if (c == '+') {
            return a + b;
        } else if (c == '-') {
            return a - b;
        } else {
            return a * b;
        }
    }

    public long solution(String expression) {
        long answer = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*') {
                nums.add(Long.parseLong(sb.toString()));
                operators.add(ch);
                sb.setLength(0);
            } else {
                sb.append(ch);
                if (i == expression.length() - 1) {
                    nums.add(Long.parseLong(sb.toString()));
                }
            }
        }

        for (int i = 0; i < 6; i++) {
            String seq = priority[i];
            ArrayList<Long> numTemp = new ArrayList<>(nums);
            ArrayList<Character> opTemp = new ArrayList<>(operators);
            for (int j = 0; j < 3; j++) {
                while (opTemp.contains(seq.charAt(j))) {
                    int idx = opTemp.indexOf(seq.charAt(j));
                    long res = calculate(numTemp.get(idx), numTemp.get(idx + 1), opTemp.get(idx));
                    numTemp.remove(idx + 1);
                    numTemp.remove(idx);
                    opTemp.remove(idx);
                    numTemp.add(idx, res);
                }
            }
            answer = Math.max(answer, Math.abs(numTemp.get(0)));
        }
        return answer;
    }
}