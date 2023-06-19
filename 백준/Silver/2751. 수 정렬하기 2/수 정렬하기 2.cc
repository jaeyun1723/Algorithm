#include<iostream>
#include<string>
#include<vector>
#include<cmath>
#include<algorithm>
using namespace std;

int main() {
	int N;
	cin >> N;
	vector <int> v;
	while (N--)
	{
		int k;
		cin >> k;
		v.push_back(k);
	}
	sort(v.begin(), v.end());

	for (int i = 0; i < v.size(); i++)
		cout << v[i] << '\n';
}