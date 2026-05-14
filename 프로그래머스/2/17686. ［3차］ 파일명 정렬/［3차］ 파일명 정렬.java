import java.util.*;

class Solution {
    // 4:07

    public File extractFile(int idx, String file) {
        StringBuilder head = new StringBuilder();
        StringBuilder number = new StringBuilder();
        StringBuilder tail = new StringBuilder();
        boolean flag = false;
        for (int i = 0; i < file.length(); i++) {
            char c = file.charAt(i);
            if (Character.isDigit(c) && number.length() < 5) { // 숫자인 경우
                flag = true;
                number.append(c);
            } else {
                if (!flag) { // 숫자가 아니면서 아직 숫자 나온적 없음
                    head.append(c);
                } else { // 숫자가 아니면서 숫자 나온적 있음.
                    tail.append(file.substring(i));
                    break;
                }
            }
        }
        return new File(idx, head.toString(), number.toString(), tail.toString());
    }

    public String[] solution(String[] files) {
        String[] answer = new String[files.length];

        ArrayList<File> list = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            list.add(extractFile(i, files[i]));
        }

        Comparator<File> comp = new Comparator<File>() {
            public int compare(File f1, File f2) {
                // HEAD
                String h1 = f1.head.toLowerCase();
                String h2 = f2.head.toLowerCase();
                if (h1.equals(h2)) {
                    // NUMBER
                    int n1 = Integer.parseInt(f1.number);
                    int n2 = Integer.parseInt(f2.number);
                    if (n1 == n2) {
                        // IDX
                        return Integer.compare(f1.idx, f2.idx);
                    }
                    return Integer.compare(n1, n2);
                }
                return h1.compareTo(h2);
            }
        };
        list.sort(comp);

        for (int i = 0; i < list.size(); i++) {
            answer[i] = files[list.get(i).idx];
        }
        return answer;
    }

    public static class File {

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