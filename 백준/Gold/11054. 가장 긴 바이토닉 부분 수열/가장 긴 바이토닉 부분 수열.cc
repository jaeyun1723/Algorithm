#include<iostream>
#include<string>
#include<vector>
#include<cmath>
#include<algorithm>
using namespace std;

int main() {
	int arr[1001] = { 0, };
	int dp[1001] = { 0, };	// 오름차순
	int dp2[1001] = { 0, };	// 내림차순
	int n;
	cin >> n;

	for (int i = 0; i < n; i++)
	{
		cin >> arr[i];
		dp[i] = 1;
		dp2[i] = 1;
	}

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < i; j++)
		{
			if (arr[j] < arr[i] && dp[i] < dp[j] + 1)
				dp[i] = dp[j] + 1;
		}
	}

	for (int i = n - 1; i >= 0; i--)
	{
		for (int j = n - 1; j > i; j--)
		{
			if (arr[j] < arr[i] && dp2[i] < dp2[j] + 1)
				dp2[i] = dp2[j] + 1;
		}
	}

	int max = 0;

	for (int i = 0; i < n; i++)
		max = (int)fmax(max, dp[i] + dp2[i]);

	cout << max - 1 << '\n';
}