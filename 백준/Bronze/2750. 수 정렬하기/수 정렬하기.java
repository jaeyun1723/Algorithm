

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n=Integer.parseInt(st.nextToken());
		arr=new int[n];
		for(int i=0;i<n;i++)
		{
			st = new StringTokenizer(br.readLine());
			arr[i]=Integer.parseInt(st.nextToken());
		}
		bubbleSort();
		for(int i=0;i<n;i++)
			System.out.println(arr[i]);
	}

	static void bubbleSort() {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1])
					swap(j, j + 1);
			}
		}
	}

	static void swap(int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
