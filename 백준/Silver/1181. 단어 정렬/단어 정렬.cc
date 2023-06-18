#include<iostream>
#include<string>
#include<vector>
#include<cmath>
#include<algorithm>
using namespace std;

bool compare(string x, string y)
{
	if (x.size() == y.size())
		return (x < y);
	return (x.size() < y.size());
}

int main() {
	int N;
	cin >> N;
	vector<string> word;

	while (N--)
	{
		string term;
		cin >> term;
		word.push_back(term);
	}

	sort(word.begin(), word.end(), compare);

	for (int i = 0; i < word.size(); i++)
	{
		if (i == 0)
			cout << word[i] << '\n';
		else if (word[i] != word[i - 1])
			cout << word[i] << '\n';
	}
}