import java.util.*;

class Solution {

    public static int timeToInt(String time) {
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }

    public String[] solution(String[][] plans) {
        String[] answer = {};
        ArrayList<String> list = new ArrayList<>();
        PriorityQueue<Plan> pq = new PriorityQueue<>((o1, o2) -> o1.start - o2.start);
        Deque<Plan> deq = new ArrayDeque<>();
        for (int i = 0; i < plans.length; i++) {
            pq.add(new Plan(plans[i][0], timeToInt(plans[i][1]), Integer.parseInt(plans[i][2])));
        }

        Plan now = pq.poll();
        while (!pq.isEmpty()) {
            Plan next = pq.poll(); // 다음 과제
            if (now.start + now.time > next.start) { // 현재 과제를 다 못 끝낼 경우
                now.time -= (next.start - now.start);
                deq.offerFirst(now);
            } else { // 현재 과제를 다 끝냈을 경우
                list.add(now.sub);
                int extra = next.start - (now.start + now.time); // 여분의 시간
                while (extra > 0 && !deq.isEmpty()) {
                    Plan p = deq.pollFirst();
                    if (p.time <= extra) { // 여분의 시간동안 과제 끝낼 수 있다면
                        list.add(p.sub);
                        extra -= p.time;
                    } else { // 여분의 시간동안 과제 못 끝낸다면
                        p.time -= extra;
                        deq.offerFirst(p);
                        break;
                    }
                }
            }
            now = next;
        }
        list.add(now.sub);
        while (!deq.isEmpty()) {
            Plan p = deq.pollFirst();
            list.add(p.sub);
        }
        answer = list.toArray(new String[0]);
        return answer;
    }

    public static class Plan {
        String sub;
        int start;
        int time;

        public Plan(String sub, int start, int time) {
            this.sub = sub;
            this.start = start;
            this.time = time;
        }
    }
}