import java.util.*;

class Solution {

    static boolean[] useTickets;
    static ArrayList<String> routes;

    public static void dfs(int len, String now, String route, String[][] tickets) {
        if (len == tickets.length) {
            routes.add(route);
            return;
        }
        for (int i = 0; i < tickets.length; i++) {
            if (!useTickets[i] && tickets[i][0].equals(now)) {
                useTickets[i] = true;
                dfs(len + 1, tickets[i][1], route + "," + tickets[i][1], tickets);
                useTickets[i] = false;
            }
        }
    }

    public String[] solution(String[][] tickets) {
        routes = new ArrayList<String>();
        useTickets = new boolean[tickets.length];

        dfs(0, "ICN", "ICN", tickets);
        Collections.sort(routes);
        return routes.get(0).split(",");
    }
}