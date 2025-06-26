import java.util.*;

class Solution {

    static Map<String, Integer> map = new HashMap<>();

    public static void addMap(StringBuilder sb, int len, int idx, String order, int size) {
        if (len == size) {
            String course = sb.toString();
            map.put(course, map.getOrDefault(course, 0) + 1);
            return;
        }
        for (int i = idx; i < order.length(); i++) {
            sb.append(order.charAt(i));
            addMap(sb, len + 1, i + 1, order, size);
            sb.deleteCharAt(len);
        }
    }

    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        ArrayList<String> list = new ArrayList<>();

        for (int count : course) {
            for (String order : orders) {
                if (order.length() < count) {
                    continue;
                }
                char[] chars = order.toCharArray();
                Arrays.sort(chars);
                order = String.valueOf(chars);
                addMap(new StringBuilder(), 0, 0, order, count);
            }

            int max = 0;
            for (int value : map.values()) {
                max = Math.max(max, value);
            }

            if (max < 2) {
                continue;
            }
            for (String str : map.keySet()) {
                if (map.get(str) == max) {
                    list.add(str);
                }
            }
            map.clear();
        }
        list.sort(null);
        return answer = list.toArray(String[]::new);
    }
}