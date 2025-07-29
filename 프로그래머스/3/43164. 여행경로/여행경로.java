import java.util.*;

class Solution {

    static Map<String, ArrayList<Ticket>> map = new HashMap<>();
    static int ticket;
    static boolean flag = false;
    static ArrayList<String> path = new ArrayList<>();

    public void dfs(String dpt, int count, boolean[] isVisit) {
        if (flag) {
            return;
        }
        if (count == ticket) {
            flag = true;
            return;
        }
        if (map.containsKey(dpt)) {
            for (Ticket t : map.get(dpt)) {
                if (!isVisit[t.no]) {
                    isVisit[t.no] = true;
                    path.add(t.en);
                    dfs(t.en, count + 1, isVisit);
                    if (flag) {
                        return;
                    }
                    path.remove(path.size() - 1);
                    isVisit[t.no] = false;
                }
            }
        }

    }

    public String[] solution(String[][] tickets) {
        String[] answer = {};
        ticket = tickets.length;
        for (int i = 0; i < tickets.length; i++) {
            String st = tickets[i][0];
            String en = tickets[i][1];
            ArrayList<Ticket> list = map.getOrDefault(st, new ArrayList<Ticket>());
            list.add(new Ticket(i, st, en));
            map.put(st, list);
        }
        for (String airport : map.keySet()) {
            ArrayList<Ticket> list = map.get(airport);
            list.sort((o1, o2) -> o1.en.compareTo(o2.en));
        }

        path.add("ICN");
        boolean[] isVisit = new boolean[tickets.length];
        dfs("ICN", 0, isVisit);
        answer = path.toArray(String[]::new);
        return answer;
    }

    public class Ticket {

        int no;
        String st;
        String en;

        public Ticket(int no, String st, String en) {
            this.no = no;
            this.st = st;
            this.en = en;
        }
    }
}