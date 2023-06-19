#include<iostream>
#include<string>
using namespace std;

int sequence(int num)
{
	int k = 0;
	int n = 1;
	while (num > n)
	{
		k++;
		n = 6 * k + n;
	}
	return k + 1;
}

int main()
{
	int num;
	cin >> num;

	cout << sequence(num) << '\n';
}