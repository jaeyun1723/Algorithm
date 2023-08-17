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

int arr[1001][1001];

int main() {
	int N, a, b;
	cin >> N >> a >> b;
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			int num;
			cin >> num;
			arr[i][j] = num;
		}
	}
	int chm = arr[a][b];
	for (int i = 1; i <= N; i++) {
		if (chm < arr[a][i] || chm < arr[i][b]) {
			cout << "ANGRY\n";
			return 0;
		}
	}
	cout << "HAPPY\n";
}