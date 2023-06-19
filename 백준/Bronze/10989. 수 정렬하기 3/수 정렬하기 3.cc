#include<iostream>
#include<string>
#include<vector>
#include<cmath>
#include<algorithm>
using namespace std;

int arr[10001];
int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int N;
	cin >> N;
	while (N--)
	{
		int num;
		cin >> num;
		arr[num]++;
	}
	for (int i = 0; i < 10001; i++)
	{
		if (arr[i] != 0)
			for (int k = 0; k < arr[i]; k++)
				cout << i << '\n';
	}
}