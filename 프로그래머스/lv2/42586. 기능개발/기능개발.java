import java.util.*;

class Solution {

    public static int complete(int progress, int speed) {
        double remain = (double) (100 - progress) / speed;
        return (int) Math.ceil(remain);
    }

    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>();
        int prev = complete(progresses[0], speeds[0]);
        int deploy = 1;
        for (int i = 1; i < progresses.length; i++) {
            int day = complete(progresses[i], speeds[i]);
            if (prev >= day) {
                deploy++;
            } else {
                list.add(deploy);
                prev = day;
                deploy = 1;
            }
        }
        list.add(deploy);
        return list.stream().mapToInt(i -> i).toArray();
    }
}