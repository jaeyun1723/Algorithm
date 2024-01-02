import java.util.*;

class Solution {
     static int[] rate;

    static int transforTime(String data) {
        String[] time = data.split(":");
        int minute = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
        return minute;
    }

    static int charge(int minute) {
        if (minute <= rate[0]) {
            return rate[1];
        } else {
            minute -= rate[0];
            return rate[1] +(int)(Math.ceil(minute / (double)rate[2])) * rate[3];
        }
    }

    static int[] solution(int[] fees, String[] records) {
        rate = fees;
        Map<String, Integer> map = new HashMap<>(); // 차량번호, 시간
        Map<String, Integer> fee = new HashMap<>(); // 차량번호, 주차요금
        for (int i = 0; i < records.length; i++) {
            String[] data = records[i].split(" ");
            int time = transforTime(data[0]);
            if (map.containsKey(data[1])) {
                int hour = time - map.get(data[1]);
                fee.put(data[1], fee.getOrDefault(data[1], 0) + hour);
                map.remove(data[1]);
            } else {
                map.put(data[1], time);
            }
        }
        int max = transforTime("23:59");
        List<String> keySet = new ArrayList(map.keySet());
        for (String key : keySet) {
            int hour = max - map.get(key);
            fee.put(key, fee.getOrDefault(key, 0) + hour);
        }

        List<String> car = new ArrayList(fee.keySet());
        Collections.sort(car);
        int[] answer = new int[fee.size()];
        for (int i = 0; i < answer.length; i++) {
            int hour = fee.get(car.get(i));
            answer[i] = charge(hour);
        }
        return answer;
    }
}