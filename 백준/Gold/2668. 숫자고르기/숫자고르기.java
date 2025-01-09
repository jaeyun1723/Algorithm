import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static ArrayList<Integer> list;
    static boolean[] isVisit;
    static int[] arr;

    public static void dfs(int start, int target) {
        if (target == arr[start]) {
            list.add(target);
            return;
        }
        if (!isVisit[arr[start]]) {
            isVisit[arr[start]] = true;
            dfs(arr[start], target);
            isVisit[arr[start]] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        list = new ArrayList<>();
        isVisit = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= N; i++) {
            isVisit[i] = true;
            dfs(i, i);
            isVisit[i] = false;
        }

        Collections.sort(list);
        System.out.println(list.size());
        for (int num : list)
            System.out.println(num);
    }
}