class Solution {

    public int solution(String name) {
        int answer = 0;
        int move = name.length() - 1;

        for (int i = 0; i < name.length(); i++) {
            // 상하 조작
            answer += Math.min(name.charAt(i) - 'A', 26 - (name.charAt(i) - 'A'));
            // 좌우 조작
            if (i < name.length() - 1 && name.charAt(i + 1) == 'A') { // A개수 구하기
                int endA = i + 1;
                while (endA < name.length() && name.charAt(endA) == 'A') {
                    endA++;
                }

                move = Math.min(move, i * 2 + (name.length() - endA)); // 오른쪽으로 갔다가 다시 왼쪽으로 꺾기
                move = Math.min(move, i + (name.length() - endA) * 2); // 왼쪽으로 갔다가 다시 오른쪽으로 꺾기
            }
        }

        return answer + move;
    }
}