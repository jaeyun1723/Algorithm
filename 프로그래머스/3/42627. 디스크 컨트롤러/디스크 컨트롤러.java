import java.util.*;

class Solution {

    public int solution(int[][] jobs) {
        int answer = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        Arrays.sort(jobs, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        int sec = 0;
        int count = 0;
        int index = 0;
        while (count < jobs.length) {
            // 현재 시간까지의 작업 넣기
            while (index < jobs.length && jobs[index][0] <= sec) {
                pq.offer(jobs[index++]);
            }
            // 현재 작업이 수행 중이면 그거 계산하기
            if (pq.isEmpty()) { // 작업할 게 없으면
                sec = jobs[index][0]; // 다음 작업 시간으로 이동
            } else {
                int[] task = pq.poll();
                sec += task[1]; // 다음 작업 시간으로 이동
                answer += sec - task[0];
                count++;
            }
        }

        return answer / jobs.length;
    }
}