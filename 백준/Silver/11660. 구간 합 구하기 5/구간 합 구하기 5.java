
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++)
				arr[i][j] = Integer.parseInt((st.nextToken()));
		}
//		System.out.println(Arrays.deepToString(arr));
		int[][] dp=new int[N+1][N+1];
		for(int i=1;i<=N;i++)
			for(int j=1;j<=N;j++)
				dp[i][j]=dp[i][j-1]+dp[i-1][j]+arr[i][j]-dp[i-1][j-1];
//		System.out.println(Arrays.deepToString(dp));
		while(M-->0) {
			int sum=0;
			st = new StringTokenizer(br.readLine());
			int x1=Integer.parseInt(st.nextToken());	// x1(0, y1(1 ,x2(2 ,y2(3
			int y1=Integer.parseInt(st.nextToken());	// x1(0, y1(1 ,x2(2 ,y2(3
			int x2=Integer.parseInt(st.nextToken());	// x1(0, y1(1 ,x2(2 ,y2(3
			int y2=Integer.parseInt(st.nextToken());	// x1(0, y1(1 ,x2(2 ,y2(3
			System.out.println(dp[x2][y2]-dp[x1-1][y2]-dp[x2][y1-1]+dp[x1-1][y1-1]);
		}

	}// etc
//						x1-1,y2	
//			 x1,y1 		x1,y2
//	
//x2,y1-1 	x2,y1		x2,y2
}// etc
