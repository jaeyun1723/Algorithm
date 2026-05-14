import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public int parseTime(String time) {
        String[] timeArr = time.split(":");
        int hours = Integer.parseInt(timeArr[0]) * 60;
        int minutes = Integer.parseInt(timeArr[1]);
        return hours + minutes;
    }

    public int[] solution(int[] fees, String[] records) {
        // 일단 상태에 따라 데이터 나누고
        // 시간변환 함수만들기
        // Map에 요금이랑 저장한 후,
        // key 오름차순정렬
        Map<String, ArrayList<Integer>> map = new HashMap<>();
        Map<String, Integer> car = new HashMap<>();
        for (int i = 0; i < records.length; i++) {
            String[] record = records[i].split(" ");
            ArrayList<Integer> time;
            if (map.containsKey(record[1])) {
                time = map.get(record[1]);
            } else {
                time = new ArrayList<>();
            }
            time.add(parseTime(record[0]));
            map.put(record[1], time);
        }
        for (String key : map.keySet()) {
            ArrayList<Integer> v = map.get(key);
            if (v.size() % 2 == 1) {
                v.add(parseTime("23:59"));
            }
            int totalTime = 0;
            int fee = fees[1];
            for (int i = 0; i < v.size(); i += 2) {
                totalTime += v.get(i + 1) - v.get(i);
            }
            if (totalTime > fees[0]) {
                int over = totalTime - fees[0]; // 초과한 시간
                int count = over / fees[2];
                if (over % fees[2] > 0) {
                    count++;
                }
                fee += count * fees[3];
            }
            car.put(key, fee);
        }
        List<String> keys = new ArrayList<>(car.keySet());
        keys.sort(null);
        int[] answer = new int[keys.size()];
        for (int i = 0; i < keys.size(); i++) {
            answer[i] = car.get(keys.get(i));
        }
        return answer;
    }

}