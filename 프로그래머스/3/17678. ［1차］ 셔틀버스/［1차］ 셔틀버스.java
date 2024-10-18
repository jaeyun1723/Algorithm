import java.util.*;

class Solution {

    public int timeToInt(String time) {
        String[] str = time.split(":");
        int hour = Integer.parseInt(str[0]);
        int minute = Integer.parseInt(str[1]);
        return hour * 60 + minute;
    }

    public String timeToStr(int time) {
        String hour = String.valueOf(time / 60);
        String minute = String.valueOf(time % 60);
        if (hour.length() == 1) {
            hour = "0" + hour;
        }
        if (minute.length() == 1) {
            minute = "0" + minute;
        }
        return hour + ":" + minute;
    }

    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < timetable.length; i++) {
            int time = timeToInt(timetable[i]);
            pq.add(time);
        }
        int count = 0;
        int start_time = 9 * 60;
        int last_time = 0;
        int total = 0;
        for (int i = 0; i < n; i++) {
            total = 0;
            while (!pq.isEmpty()) {
                int current_time = pq.peek();
                if (current_time <= start_time && total < m) {
                    pq.poll();
                    total++;
                } else {
                    break;
                }
                last_time = current_time - 1;
            }
            start_time += t;
        }
        if (total < m) {
            last_time = start_time - t;
        }

        return timeToStr(last_time);
    }
}