import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        String word = br.readLine();

        int[] alphabet = new int[26];

        for (int i = 0; i < word.length(); i++) {
            alphabet[word.charAt(i) - 'A']++;
        }

        int answer = 0;

        for (int i = 1; i < N; i++) {
            String str = br.readLine();
            if (Math.abs(word.length() - str.length()) >= 2) continue;
            int[] newAlphabet = Arrays.copyOf(alphabet, alphabet.length);
            int cnt = 0;
            for (int j = 0; j < str.length(); j++) {
                int idx = str.charAt(j) - 'A';
                if (newAlphabet[idx] > 0) {
                    cnt++;
                    newAlphabet[idx]--;
                }
            }
            if (str.length() == word.length() - 1 && cnt == str.length()) {
                // str의 길이가 작은 경우, word에 있는 알파벳 범주 안에 있어야함.
                answer++;
            } else if (str.length() == word.length() + 1 && cnt == word.length()) {
                // str의 길이가 클 경우, word에 있는 알파벳을 모두 포함해야 함.
                answer++;
            } else if (str.length() == word.length()) {
                // str의 길이가 같은 경우, word에 있는 알파벳과 구성이 같거나 다른 게 하나면 된다.
                if (cnt == str.length() - 1 || cnt == str.length()) answer++;
            }

        }
        System.out.println(answer);
    }
}