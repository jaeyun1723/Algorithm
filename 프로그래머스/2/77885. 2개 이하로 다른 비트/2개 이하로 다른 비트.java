import java.util.*;

class Solution {

    public static long match(String num1, String num2, long cnt) {
        int idx1 = num1.length() - 1;
        int idx2 = num2.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (cnt > 2) {
            if (num1.charAt(idx1) != num2.charAt(idx2)) {
                sb.append(num1.charAt(idx1));
                cnt--;
            } else {
                sb.append(num2.charAt(idx2));
            }
            idx1--;
            idx2--;
        }
        while(idx2>=0){
            sb.append(num2.charAt(idx2--));
        }
        return Long.parseLong(sb.reverse().toString(),2);
    }

    public static long diff(String num1, String num2) {
        if (num2.length() == num1.length() + 1) {
            return num2.length();
        } else {
            int count = 0;
            for (int i = num1.length() - 1; i >= 0; i--) {
                if (num1.charAt(i) != num2.charAt(i)) {
                    count++;
                }
            }
            return count;
        }
    }

    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            String num1 = Long.toBinaryString(numbers[i]);
            String num2 = Long.toBinaryString(numbers[i] + 1);
            long cnt = diff(num1, num2);
            if (cnt <= 2) {
                answer[i] = numbers[i] + 1;
            } else {
                answer[i] = match(num1, num2, cnt);
            }
        }

        return answer;
    }
}