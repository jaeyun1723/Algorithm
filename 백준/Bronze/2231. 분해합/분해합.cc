#include<iostream>
#include<string>
#include<vector>
#include<cmath>
using namespace std;

int main() {
	int N;
	cin >> N;

	for (int i = 0; i < N; i++)
	{
		int sum = i;
		int n = i;
		while (n != 0)
		{
			sum += n % 10;
			n = n / 10;
		}

		if (sum == N)
		{
			cout << i << '\n';
			return 0;
		}
	}
	cout << 0 << '\n';
}