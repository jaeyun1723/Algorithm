#include<iostream>
#include<string>
#include<vector>
using namespace std;

int main()
{
	int M, N;
	cin >> M >> N;
	vector<bool> v(N - M + 1, false);

	for (int i = M; i <= N; i++)
	{
		if (i == 1)
			v[i - M] = true;
		for (int j = 2; j < i; j++)
		{
			if (i % j == 0)
			{
				v[i - M] = true;
				break;
			}
		}

	}
	int min = -1;
	for (int i = 0; i < v.size(); i++)
	{
		if (v[i] == false)
		{
			min = i + M;
			break;
		}
	}
	int tot = 0;
	for (int i = 0; i < v.size(); i++)
	{
		if (v[i] == false)
			tot += i + M;
	}
	if (tot == 0)
		cout << -1 << "\n";
	else
	{
		cout << tot << '\n';
		cout << min << '\n';
	}
}