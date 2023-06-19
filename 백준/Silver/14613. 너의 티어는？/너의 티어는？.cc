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

double dp[21][3501];

int main() {
	double W, L, D;
	cin >> W >> L >> D;

	dp[0][2000] = 1;

	for (int i = 1; i <= 20; i++) {
		for (int j = 1000; j <= 3500; j++) {
			if (dp[i - 1][j] == 0) continue;

			dp[i][j - 50] += dp[i - 1][j] * L;
			dp[i][j + 50] += dp[i - 1][j] * W;
			dp[i][j] += dp[i - 1][j] * D;
		}
	}

	double bronze, silver, gold, platinum, diamond;
	bronze = silver = gold = platinum = diamond = 0.0;

	for (int i = 1000; i <= 3500; i++) {
		if (1000 <= i && i <= 1499) bronze += dp[20][i];
		else if (1500 <= i && i <= 1999) silver += dp[20][i];
		else if (2000 <= i && i <= 2499) gold += dp[20][i];
		else if (2500 <= i && i <= 2999) platinum += dp[20][i];
		else diamond += dp[20][i];
	}
	cout << fixed;
	cout.precision(8);
	cout << bronze << '\n' << silver << '\n' << gold << '\n' << platinum << '\n' << diamond << '\n';
}