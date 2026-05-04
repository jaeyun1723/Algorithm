import java.util.*;

class Solution {

    public String[] solution(String[] files) {
        String[] answer = new String[files.length];

        ArrayList<File> list = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            String file = files[i];
            StringBuilder head = new StringBuilder();
            StringBuilder number = new StringBuilder();
            StringBuilder tail = new StringBuilder();
            boolean flag = false;
            for (int j = 0; j < file.length(); j++) {
                char c = file.charAt(j);
                if (c >= '0' && c <= '9') {
                    flag = true;
                    number.append(c);
                } else {
                    if (flag) {
                        tail.append(file.substring(j));
                        break;
                    } else {
                        head.append(c);
                    }
                }
            }
            list.add(new File(i, head.toString(), number.toString(), tail.toString()));
        }

        list.sort(new Comparator<File>() {
            public int compare(File o1, File o2) {
                if (o1.head.toLowerCase().equals(o2.head.toLowerCase())) {
                    if (Integer.parseInt(o1.number) == Integer.parseInt(o2.number)) {
                        return Integer.compare(o1.idx, o2.idx);
                    } else {
                        return Integer.compare(Integer.parseInt(o1.number),
                            Integer.parseInt(o2.number));
                    }
                } else {
                    return o1.head.toLowerCase().compareTo(o2.head.toLowerCase());
                }
            }
        });

        for (int i = 0; i < answer.length; i++) {
            answer[i] = files[list.get(i).idx];
        }
        return answer;
    }

    public class File {

        int idx;
        String head;
        String number;
        String tail;

        public File(int idx, String head, String number, String tail) {
            this.idx = idx;
            this.head = head;
            this.number = number;
            this.tail = tail;
        }
    }
}