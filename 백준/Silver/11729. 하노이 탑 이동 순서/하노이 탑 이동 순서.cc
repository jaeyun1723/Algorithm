#include<iostream>
#include<string>
#include<vector>
#include<cmath>
using namespace std;

void hanoi(int n, int start, int mid, int end)
{
	if (n == 1)
		cout << start << " " << end << '\n';
	else
	{
		hanoi(n - 1, start, end, mid);
		cout << start << " " << end << '\n';
		hanoi(n - 1, mid, start, end);
	}
}

int hanoi(int n)
{
	if (n == 1) return 1;
	return hanoi(n - 1) + 1 + hanoi(n - 1);
}

int main() {
	int n;
	cin >> n;
	cout << hanoi(n) << '\n';
	hanoi(n, 1, 2, 3);
	return 0;
}