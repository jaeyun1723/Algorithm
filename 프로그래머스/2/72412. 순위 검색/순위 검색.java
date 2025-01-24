import java.util.*;

class Solution {

    static HashMap<String, ArrayList<Integer>> map;

    public static void registSpec(int idx, String[] spec, String str) {
        if (idx == 4) {
            ArrayList<Integer> list;
            if (!map.containsKey(str))
                list = new ArrayList<>();

            else
                list = map.get(str);
            list.add(Integer.parseInt(spec[idx]));
            map.put(str, list);
            return;
        }
        registSpec(idx + 1, spec, str + spec[idx]);
        registSpec(idx + 1, spec, str + "-");
    }

    public static int binarySearch(ArrayList<Integer> list, int score) {
        int left = 0, right = list.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (list.get(mid) < score)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return list.size() - left;
    }

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        map = new HashMap<>();

        for (int i = 0; i < info.length; i++) {
            String[] spec = info[i].split(" ");
            registSpec(0, spec, "");
        }

        for (String key : map.keySet()) {
            Collections.sort(map.get(key));
        }

        for (int i = 0; i < query.length; i++) {
            String[] q = query[i].replace(" and ", "").split(" ");
            answer[i] = map.containsKey(q[0]) ? binarySearch(map.get(q[0]), Integer.parseInt(q[1])) : 0;
        }
        return answer;
    }
}