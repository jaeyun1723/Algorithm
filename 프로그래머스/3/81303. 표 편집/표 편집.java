import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        StringBuilder answer = new StringBuilder();
        Node[] list = new Node[n]; // Node 배열로 리스트 구성
        Stack<Node> stk = new Stack<>();

        // Node 객체 생성 및 연결
        list[0] = new Node(null, null, false); // 첫 번째 노드
        for (int i = 1; i < n; i++) {
            list[i] = new Node(list[i - 1], null, false); // 현재 노드 생성
            list[i - 1].next = list[i]; // 이전 노드와 연결
        }

        Node cursor = list[k]; // 현재 커서 위치 초기화

        // 명령어 처리
        for (String query : cmd) {
            char command = query.charAt(0);
            if (command == 'U') {
                int move = Integer.parseInt(query.substring(2));
                for (int i = 0; i < move; i++) {
                    if (cursor.prev != null) cursor = cursor.prev;
                }
            } else if (command == 'D') {
                int move = Integer.parseInt(query.substring(2));
                for (int i = 0; i < move; i++) {
                    if (cursor.next != null) cursor = cursor.next;
                }
            } else if (command == 'C') {
                cursor.isDelete = true; // 현재 노드 삭제 표시
                stk.push(cursor); // 스택에 삭제된 노드 저장

                // 연결 업데이트
                Node prev = cursor.prev;
                Node next = cursor.next;

                if (prev != null) prev.next = next; // 이전 노드의 다음을 현재의 다음으로 연결
                if (next != null) next.prev = prev; // 다음 노드의 이전을 현재의 이전으로 연결

                cursor = (next != null) ? next : prev; // 다음 노드로 이동, 없으면 이전 노드로 이동
            } else if (command == 'Z') {
                if (!stk.isEmpty()) {
                    Node restore = stk.pop(); // 복구할 노드
                    restore.isDelete = false; // 삭제 해제

                    // 연결 복구
                    Node prev = restore.prev;
                    Node next = restore.next;

                    if (prev != null) prev.next = restore;
                    if (next != null) next.prev = restore;
                }
            }
        }

        // 결과 생성
        for (Node node : list) {
            answer.append(node.isDelete ? 'X' : 'O');
        }

        return answer.toString();
    }

    // Node 클래스 정의
    static class Node {
        Node prev; // 이전 노드 참조
        Node next; // 다음 노드 참조
        boolean isDelete; // 삭제 여부

        public Node(Node prev, Node next, boolean isDelete) {
            this.prev = prev;
            this.next = next;
            this.isDelete = isDelete;
        }
    }
}
