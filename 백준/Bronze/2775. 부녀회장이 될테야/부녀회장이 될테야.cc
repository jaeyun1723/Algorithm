#include<iostream>
#include<string>
using namespace std;

int main() {
	int T;
	cin >> T;
	int arr[15][15] = { 0, };
	for (int i = 1; i < 15; i++)
	{
		arr[0][i] = i;
		arr[i][1] = 1;
	}
	while (T--)
	{
		int a, b;
		cin >> a >> b;
		for (int i = 1; i <= a; i++)
		{
			for (int j = 1; j <= b; j++)
			{
				arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
			}
		}
		cout << arr[a][b] << '\n';
	}

}