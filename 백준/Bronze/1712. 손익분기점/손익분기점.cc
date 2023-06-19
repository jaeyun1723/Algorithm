#include<iostream>
#include<string>
using namespace std;

int main()
{
	int a, b, c;
	cin >> a >> b >> c;

	if (c - b <= 0) cout << -1 << '\n';
	else
		cout << a / (c - b) + 1 << '\n';
}