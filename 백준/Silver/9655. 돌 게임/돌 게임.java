import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        if (N % 2 == 1 || N % 4 == 1 || N % 4 == 3 || N % 6 == 3) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }

    }
}