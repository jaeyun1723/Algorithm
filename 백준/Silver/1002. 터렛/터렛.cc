#include<iostream>
#include<string>
#include<vector>
#include<cmath>
using namespace std;

int main() {
	int T;
	cin >> T;
	while (T--)
	{
		int x, y, r, X, Y, R;
		cin >> x >> y >> r >> X >> Y >> R;
		if (x == X && y == Y && r == R)
			cout << -1 << '\n';
		else if (pow(x - X, 2) + pow(y - Y, 2) == pow(r + R, 2) || pow(x - X, 2) + pow(y - Y, 2) == pow(r - R, 2))
			cout << 1 << '\n';
		else if (pow(x - X, 2) + pow(y - Y, 2) > pow(r + R, 2) || pow(x - X, 2) + pow(y - Y, 2) < pow(r - R, 2))
			cout << 0 << '\n';
		else
			cout << 2 << '\n';
	}
}