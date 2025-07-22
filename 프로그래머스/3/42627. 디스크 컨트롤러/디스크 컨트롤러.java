import java.util.*;

class Solution {

    public int solution(int[][] jobs) {
        int answer = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[2] == o2[2]) {
                    if (o1[1] == o2[1]) {
                        return Integer.compare(o1[0], o2[0]);
                    }
                    return Integer.compare(o1[1], o2[1]);
                }
                return Integer.compare(o1[2], o2[2]);
            }
        });

        Arrays.sort(jobs, (o1, o2) -> Integer.compare(o1[0], o2[0]));

        int done = 0;
        int time = 0;
        int idx = 0;
        while (done < jobs.length) {
            while (idx < jobs.length && jobs[idx][0] <= time) {
                int[] job = {idx, jobs[idx][0], jobs[idx][1]};
                pq.add(job);
                idx++;
            }
            if (pq.isEmpty()) {
                time = jobs[idx][0];
            } else {
                int[] job = pq.poll();
                int finish = time + job[2];
                answer += finish - job[1];
                done++;
                time = finish;
            }
        }

        return answer /= jobs.length;
    }
}