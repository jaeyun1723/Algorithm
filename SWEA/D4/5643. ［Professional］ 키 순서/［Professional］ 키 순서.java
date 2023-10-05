import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static Queue<int[]> queue = new ArrayDeque<>();
	static boolean[] visited;
	static int N;
	static boolean[][] map;
	private static boolean find(int n) {
	   int cnt = 0;
	   int[] pos = {n, 0};//시작지점은 큰거 작은거 다 들어와야 함.
	   queue.offer(pos);
	   visited[n] = true;
	 
	   while (!queue.isEmpty()) {
	      pos = queue.poll();
	      cnt++;
	      for (int i = 1; i <= N; i++) {
	         if (visited[i]) continue;
	         if (pos[1] >= 0 && map[pos[0]][i]) {//나보다 큰
	            queue.offer(new int[]{i, 1});
	            visited[i] = true;
	         }
	         if (pos[1] <= 0 && map[i][pos[0]]) {//나보다 작은
	            queue.offer(new int[]{i, -1});
	            visited[i] = true;
	         }
	      }
	   }
	 
	   return cnt == N;
	} 
	public static void main(String[] args) throws IOException {
	   BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	   StringTokenizer st;
	   StringBuilder sb = new StringBuilder();
	   int T = Integer.parseInt(in.readLine());
	   for (int tc = 1; tc <= T; tc++) {
	      N = Integer.parseInt(in.readLine());
	      int M = Integer.parseInt(in.readLine());
	      map = new boolean[N + 1][N + 1];
	 
	      for (int i = 0; i < M; i++) {
	         st = new StringTokenizer(in.readLine());
	         map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
	      }
	 
	      int result = 0;
	      for (int i = 1; i <= N; i++) {
	         visited = new boolean[N + 1];
	         if (find(i)) ++result;
	      }
	 
	      sb.append('#').append(tc).append(' ').append(result).append('\n');
	   }
	   System.out.print(sb);
	}

}