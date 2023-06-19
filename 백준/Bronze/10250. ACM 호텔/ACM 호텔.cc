#include<iostream>
#include<string>
using namespace std;

int main()
{
	int T;
	cin >> T;
	while (T--)
	{
		int floor, length, visitor;
		cin >> floor >> length >> visitor;

		if (visitor % floor == 0)
			cout << floor * 100 + visitor / floor << '\n';
		else
			cout << visitor % floor * 100 + visitor / floor + 1 << '\n';
	}
}