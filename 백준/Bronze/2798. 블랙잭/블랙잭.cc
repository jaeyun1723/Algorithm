#include<iostream>
#include<string>
#include<vector>
#include<cmath>
using namespace std;

int main() {
	int N, M;
	cin >> N >> M;
	vector <int> v;
	while (N--)
	{
		int num;
		cin >> num;
		v.push_back(num);
	}
	int max = 0;
	for (int i = 0; i < v.size(); i++)
	{
		for (int j = i + 1; j < v.size(); j++)
		{
			for (int k = j + 1; k < v.size(); k++)
			{
				if (v[i] + v[j] + v[k] <= M)
				{
					if (v[i] + v[j] + v[k] > max)
						max = v[i] + v[j] + v[k];
				}
			}
		}
	}
	cout << max << '\n';
}