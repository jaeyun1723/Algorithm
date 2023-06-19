#define _CRT_SECURE_NO_WARNINGS
#include<iostream>
#include<string>
#include<vector>
#include<cmath>
#include<algorithm>
#include<stack>
#include<queue>
#include<map>
#include<deque>
#include<list>
using namespace std;

long long gcd(long long a, long long b) {
	long long c;
	while (b != 0) {
		c = a % b;
		a = b;
		b = c;
	}
	return a;
}

int main() {
	long long a, b, i, diff;
	cin >> a >> b;
	diff = b - a;
	i = 1;

	while (i * i <= a)
		i++;
//	cout << i << '\n';

	int cnt = 0;

	while (i * i <= b) {
		i++;
		cnt++;
	}

	if (cnt == 0) {
		cout << 0 << '\n';
		return 0;
	}
	long long GCD;
	GCD = gcd(diff, cnt);
	cnt /= GCD;
	diff /= GCD;
	cout << cnt << "/" << diff << '\n';
}