import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        ArrayList<String> list = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < record.length; i++) {
            String[] command = record[i].split(" ");
            if (command[0].equals("Enter")) {
                map.put(command[1], command[2]);
                list.add(command[1] + " 님이 들어왔습니다.");
            } else if (command[0].equals("Leave")) {
                list.add(command[1] + " 님이 나갔습니다.");
            } else {
                map.put(command[1], command[2]);
            }
        }
        answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            String uid = list.get(i).split(" ")[0];
            answer[i] = list.get(i).replace(uid + " ", map.get(uid));
        }
        return answer;
    }
}