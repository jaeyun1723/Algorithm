import java.util.ArrayList;
import java.util.HashMap;

class Solution {

    static ArrayList[] timestamp;
    static int[][] point;


    public static ArrayList<int[]> robotPath(int[] routes) {
        ArrayList<int[]> path = new ArrayList<>();
        path.add(new int[]{point[routes[0] - 1][0], point[routes[0] - 1][1]});
        for (int i = 1; i < routes.length; i++) {
            int[] start = point[routes[i - 1] - 1];
            int[] end = point[routes[i] - 1];
            int r = start[0];
            int c = start[1];
            while (r != end[0]) {
                r += (r < end[0]) ? 1 : -1;
                path.add(new int[]{r, c});
            }
            while (c != end[1]) {
                c += (c < end[1]) ? 1 : -1;
                path.add(new int[]{r, c});
            }
        }
        return path;
    }

    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        point = points;
        timestamp = new ArrayList[routes.length];
        for (int i = 0; i < timestamp.length; i++) {
            timestamp[i] = new ArrayList<int[]>();
        }

        int maxSec = 0;
        for (int i = 0; i < routes.length; i++) {
            timestamp[i] = robotPath(routes[i]);
            maxSec = Math.max(maxSec, timestamp[i].size());
        }

        for (int t = 0; t < maxSec; t++) {
            HashMap<String, Integer> map = new HashMap<>();
            for (ArrayList<int[]> list : timestamp) {
                if (list.size() <= t) {
                    continue;
                }
                int[] loc = list.get(t);
                String str = loc[0] + "," + loc[1];
                map.put(str, map.getOrDefault(str, 0) + 1);
            }

            for (String key : map.keySet()) {
                if (map.get(key) >= 2) {
                    answer++;
                }
            }
        }
        return answer;
    }

}