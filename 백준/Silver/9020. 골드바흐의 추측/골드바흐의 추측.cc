#include<iostream>
#include<string>
#include<vector>
using namespace std;

bool Prime[10001];

int abs(int n1, int n2)
{
	if (n1 - n2 < 0)
		return n2 - n1;
	else
		return n1 - n2;
}
int main()
{
	Prime[0] = Prime[1] = true;
	for (int i = 2; i < 10001; i++)
	{
		for (int j = 2; j <= 10001 / i; j++)
			Prime[i * j] = true;
	}
	vector<int> prime;
	for (int i = 2; i < 10001; i++)
	{
		if (Prime[i] == false)
			prime.push_back(i);
	}
	int T;
	cin >> T;
	while (T--)
	{
		int N;
		cin >> N;
		int a, b;
		a = b = 0;
		for (int i = 0; prime[i] < N; i++)
		{
			for (int j = 0; prime[j] < N; j++)
			{
				if (prime[i] + prime[j] == N)
				{
					if (a == 0 && b == 0)
					{
						a = prime[i];
						b = prime[j];
					}
					else
					{
						if (abs(a, b) > abs(prime[i], prime[j]))
						{
							a = prime[i];
							b = prime[j];
						}
					}
				}
			}
		}
		cout << a << " " << b << "\n";
	}
}