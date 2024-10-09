import java.util.*;

class Solution {

    public int solution(int cacheSize, String[] cities) {
        Map<String, Integer> map = new HashMap<>();
        int sec = 0;
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        for (int i = 0; i < cities.length; i++) {
            String str = cities[i].toLowerCase();
            if (map.size() < cacheSize) {
                if (map.containsKey(str)) {
                    sec += 1;
                } else {
                    sec += 5;
                }
            } else {
                if (map.containsKey(str)) {
                    sec += 1;
                } else {
                    String target = "";
                    int idx = i;
                    for (String key : map.keySet()) {
                        if (map.get(key) < idx) {
                            idx = map.get(key);
                            target = key;
                        }
                    }
                    map.remove(target);
                    sec += 5;
                }
            }
            map.put(str, i);
        }
        return sec;
    }

}