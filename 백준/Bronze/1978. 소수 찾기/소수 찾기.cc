#include<iostream>
#include<string>
using namespace std;

bool arr[1001];

void primeNum()
{
	arr[0] = true;
	arr[1] = true;
	for (int i = 2; i <= 1001; i++)
	{
		for (int j = 2; j <= 1001 / i; j++)
			arr[i * j] = true;
	}
}
int main() {
	int T;
	cin >> T;

	int prn = 0;
	primeNum();
	for (int i = 0; i < T; i++)
	{
		int N;
		cin >> N;
		if (arr[N] == false)
			prn++;
	}
	cout << prn << '\n';
}