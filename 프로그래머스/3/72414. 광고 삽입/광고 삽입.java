class Solution {

    public static int timeToInt(String time) {
        String[] str = time.split(":");
        return 3600 * Integer.parseInt(str[0]) + 60 * Integer.parseInt(str[1]) + Integer.parseInt(str[2]);
    }

    public static String intToTime(int time) {
        int hour = time / 3600;
        time -= hour * 3600;
        int minute = time / 60;
        time -= minute * 60;
        return format(hour) + ":" + format(minute) + ":" + format(time);
    }

    public static String format(int time) {
        if (time < 10)
            return "0" + String.valueOf(time);
        return String.valueOf(time);
    }

    public String solution(String play_time, String adv_time, String[] logs) {
        int[] video = new int[60 * 60 * 100];
        for (String log : logs) {
            String[] time = log.split("-");
            int start = timeToInt(time[0]);
            int end = timeToInt(time[1]);
            for (int j = start; j < end; j++) {
                video[j]++;
            }
        }

        int advTime = timeToInt(adv_time);
        int startTime = 0;
        long maxAdvTime = 0;

        for (int i = 0; i < advTime; i++) {
            maxAdvTime += video[i];
        }
        long totalTime = maxAdvTime;

        for (int i = advTime; i < timeToInt(play_time); i++) {
            totalTime += video[i] - video[i - advTime];
            if (maxAdvTime < totalTime) {
                startTime = i - advTime + 1;
                maxAdvTime = totalTime;
            }
        }
        return intToTime(startTime);
    }
}