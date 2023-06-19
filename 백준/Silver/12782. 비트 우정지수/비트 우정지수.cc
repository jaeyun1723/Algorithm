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

int main() {
	int T;
	cin >> T;
	while (T--) {
		string N, M;
		int stat0 = 0;
		int stat1 = 0;
		cin >> N >> M;
		for (int i = 0; i < N.size(); i++) {
			if (N[i] != M[i]) {
				if (N[i] == '0') stat0++;
				else stat1++;
			}
		}
		int max = (stat0 > stat1) ? stat0 : stat1;
		cout << max << '\n';
	
	}
}