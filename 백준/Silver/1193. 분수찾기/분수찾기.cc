#include<iostream>
#include<string>
using namespace std;

void member(int num)
{
	int k = 1;
	int n = 1;
	while (num > n)
	{
		k++;
		n = k * (k + 1) / 2;
	}
	int seq = k + 1;
	for (n = k * (k - 1) / 2; n != num; n++)
		seq--;
	if (k % 2 != 0)
		cout << seq << "/" << (k - seq + 1) << '\n';
	else
		cout << (k - seq + 1) << "/" << seq << '\n';
}

int main()
{
	int num;
	cin >> num;

	member(num);
}