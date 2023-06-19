import java.util.*;

class Solution {
    public int solution(int[] order) {
            Deque<Integer> stack = new ArrayDeque<>(); // 보조 컨테이너 벨트를 생성합니다.
        int n = order.length;
        int num = 1; // 컨테이너 벨트에서 내린 택배상자 번호
        int top = 0; // 주어진 순서배열의 index
        int answer = 0; // 트럭에 실린 상자의 수

        while (0 <= top && top < n) {
            // 컨테이너 벨트의 맨 앞 상자의 번호 > 실어야 하는 상자 번호
            // 더 이상의 상자는 주어진 순서대로 실을 수 없기 때문에 while문을 빠져나온다.
            if (!stack.isEmpty() && stack.peek() > order[top]) {
                break;
            }

            // 컨테이너 벨트에서 상자를 내린다.
            // 언제까지? 순서 번호가 될 때까지
            while (num <= order[top]) {
                stack.addFirst(num); // 보조 컨테이너 벨트에 보관합니다.
                num++;
            }

           
                answer++;
                stack.pollFirst();  // 보조 컨테이너 벨트에서 뺍니다.
              
        

            // 주어진 순서번호를 증가시킨다.
            
           top++;

        }

        return answer;
    }
}