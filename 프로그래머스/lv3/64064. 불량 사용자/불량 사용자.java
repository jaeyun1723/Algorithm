import java.util.*;

class Solution {

    Set<String> set = new HashSet<>();

    public boolean isMatch(String user, String ban) {
        if (user.length() != ban.length()) {
            return false;
        }
        for (int i = 0; i < user.length(); i++) {
            if (ban.charAt(i) == '*') {
                continue;
            }
            if (user.charAt(i) != ban.charAt(i)) {
                return false;
            }
        }
        return true;

    }

    public void matches(String[] user, String[] ban, boolean[] isBanned, int idx,
        ArrayList<String> list) {
        if (idx == ban.length) {
            list.sort(null);
            StringBuilder sb = new StringBuilder();
            for (String str : list) {
                sb.append(str);
            }
            set.add(sb.toString());
            return;
        }
        for (int i = 0; i < user.length; i++) {
            if (isBanned[i]) {
                continue;
            }
            if (isMatch(user[i], ban[idx])) {
                isBanned[i] = true;
                list.add(user[i]);
                matches(user, ban, isBanned, idx + 1, list);
                list.remove(user[i]);
                isBanned[i] = false;
            }
        }
    }

    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        boolean[] isBanned = new boolean[user_id.length];
        matches(user_id, banned_id, isBanned, 0, new ArrayList<>());
        return answer = set.size();
    }
}