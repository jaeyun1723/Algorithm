#include<iostream>
#include<string>
#include<vector>
#include<cmath>
#include<algorithm>
#include<stack>
#include<queue>
using namespace std;

int gcd(int a, int b)
{
	int x = fmax(a, b);
	int y = (x == a) ? b : a;
	int z;
	while (1)
	{
		z = x % y;
		if (z == 0) break;
		else
		{
			x = y;
			y = z;
		}
	}
	return y;
}

int main() {
	int N;
	cin >> N;

	vector<int> v;
	v.resize(N);

	for (int i = 0; i < N; i++)
	{
		cin >> v[i];
		v[i] *= 2;
	}

	for (int i = 1; i < N; i++)
	{ 
		int g = gcd(v[0], v[i]);
		cout << v[0] / g << "/" << v[i] / g << '\n';
	}
}