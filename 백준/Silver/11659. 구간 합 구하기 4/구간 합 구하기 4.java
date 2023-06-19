
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M=sc.nextInt();
		int N=sc.nextInt();
		int[] arr= new int[M+1];
		int[] dp=new int[M+1];
		for(int i=0;i<M;i++)
		arr[i+1]=sc.nextInt();
		dp[0]=0;
		for(int i=1;i<=M;i++)
			dp[i]=dp[i-1]+arr[i];
		int sum=0;
		while(N-->0) {
			int i,j;
			sum=0;
			i=sc.nextInt();
			j=sc.nextInt();
			System.out.println(dp[j]-dp[i]+arr[i]);
		}
	}

}
