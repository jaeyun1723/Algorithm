#include<iostream>
#include<string>
#include<vector>
#include<cmath>
#include<algorithm>
using namespace std;

int main() {

	int N, K;
	cin >> N >> K;

	vector<int> v;
	v.resize(N);

	for (int i = 0; i < v.size(); i++)
		cin >> v[i];

	int cnt = 0;
	for (int i = N - 1; i >= 0; i--) 
	{
		cnt += K / v[i];
		K = K % v[i];
	}

	cout << cnt << '\n';
}