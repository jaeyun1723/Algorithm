import java.util.*;

class Solution {

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        //enroll의 i번째는 referral i번째가 부모
        int[] answer = new int[enroll.length];
        // (자식,부모)
        Map<String, String> map = new HashMap<>();
        Map<String, Integer> total = new HashMap<>();
        for (int i = 0; i < enroll.length; i++) {
            map.put(enroll[i], referral[i]);
            total.put(enroll[i], 0);
        }
        map.put("-", "center");
        total.put("-", 0);
        for (int i = 0; i < seller.length; i++) {
            total.put(seller[i], total.get(seller[i]) + amount[i] * 100);
            String child = seller[i];
            int money = amount[i] * 100;
            while (money / 10 > 0) {
                if (map.containsKey(map.get(child))) {
                    total.put(map.get(child), total.get(map.get(child)) + money / 10);
                    total.put(child, total.get(child) - money / 10);
                } else {
                    break;
                }
                money /= 10;
                child = map.get(child);
            }
        }
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = total.get(enroll[i]);
        }
        return answer;
    }
}