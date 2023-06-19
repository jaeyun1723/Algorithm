#include<iostream>
#include<string>
#include<vector>
using namespace std;

bool arr[1000001];

int main()
{
	int M, N;
	cin >> M >> N;
	
	arr[0] = arr[1] = true;
	for (int i = 2; i < 1000001; i++)
	{
		for (int j = 2; j <= 1000001 / i; j++)
			arr[i * j] = true;
	}

	for (int i = M; i <= N; i++)
	{
		if (arr[i] == false)
			cout << i << '\n';
	}
}