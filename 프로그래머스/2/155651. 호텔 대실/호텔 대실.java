
class Solution {

    public static int parseInt(String time) {
        String[] t = time.split(":");
        int hour = Integer.parseInt(t[0]);
        int minute = Integer.parseInt(t[1]);
        return hour * 60 + minute;
    }

    public int solution(String[][] book_time) {
        int answer = 0;
        int[] timeSlot = new int[1440];

        for (int i = 0; i < book_time.length; i++) {
            String startTime = book_time[i][0];
            String endTime = book_time[i][1];
            int start = parseInt(startTime);
            int end = parseInt(endTime);
            for (int j = start; j < Math.min(end + 10, 1440); j++) {
                timeSlot[j]++;
            }
        }

        for (int i = 0; i < timeSlot.length; i++) {
            answer = Math.max(answer, timeSlot[i]);
        }

        return answer;
    }
}