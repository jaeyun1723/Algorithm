#include<iostream>
#include<string>
#include<vector>
#include<cmath>
#include<algorithm>
using namespace std;

bool compare(pair<int, int> x, pair<int, int> y)
{
	if (x.second == y.second)
		return (x.first < y.first);
	return (x.second < y.second);
}

int main() {
	int N;
	cin >> N;
	vector<pair<int, int> > v;
	while (N--)
	{
		int x, y;
		cin >> x >> y;
		v.push_back(make_pair(x, y));
	}

	sort(v.begin(), v.end(), compare);

	for (int i = 0; i < v.size(); i++)
		cout << v[i].first << " " << v[i].second << '\n';
}