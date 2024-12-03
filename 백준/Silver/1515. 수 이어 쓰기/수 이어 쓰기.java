import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int at = 0;
        for (int i = 1; i <= 30000; i++) {
            String num = String.valueOf(i);
            for (int j = 0; j < num.length(); j++) {
                if (str.charAt(at) == num.charAt(j)) {
                    at++;
                }
                if (at == str.length()) {
                    System.out.println(i);
                    return;
                }
            }
        }
    }
}