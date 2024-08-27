import java.util.*;

class Solution {
    static String[] users;
    static String[] bans;
    static HashSet<HashSet<String>> sets;

    public static boolean isEqual(String user, String ban) {
        if (user.length() != ban.length()) return false;
        for (int i = 0; i < ban.length(); i++) {
            if (ban.charAt(i) == '*') continue;
            if (user.charAt(i) != ban.charAt(i)) return false;
        }
        return true;
    }

    public void banList(HashSet<String> set, int depth) {
        if (depth == bans.length) {
            sets.add(set);
            return;
        }
        for (int i = 0; i < users.length; i++) {
            if (set.contains(users[i])) continue;
            if (isEqual(users[i], bans[depth])) {
                set.add(users[i]);
                banList(new HashSet<String>(set), depth + 1);
                set.remove(users[i]);
            }
        }
    }

    public int solution(String[] user_id, String[] banned_id) {
        users = user_id;
        bans = banned_id;
        sets = new HashSet<>();
        banList(new HashSet<String>(), 0);

        return sets.size();
    }
}