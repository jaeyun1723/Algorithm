import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {


    public static boolean sEqualsT(String s1, String s2) {
        if (s1.length() == s2.length()) {
            if (s1.equals(s2)) {
                return true;
            }
            return false;
        }
        if (s1.endsWith("A") && sEqualsT(s1.substring(0, s1.length() - 1), s2))
            return true;
        if (s1.startsWith("B") && sEqualsT(new StringBuilder(s1.substring(1)).reverse().toString(), s2))
            return true;
        return false;
    }

    // baa
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String t = br.readLine();

        if (sEqualsT(t, s))
            System.out.println(1);
        else
            System.out.println(0);

    }
}