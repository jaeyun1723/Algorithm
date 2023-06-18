#include<iostream>
#include<string>
using namespace std;

int main()
{
	string sentence;
	getline(cin, sentence);
	int cnt = 1;
	for (int i = 0; i < sentence.size(); i++)
	{
		if (sentence[i] == ' ' && sentence[i + 1] != ' ')
			if (i != 0 && i != sentence.size() - 1)
				cnt++;
	}
	if (sentence.size() == 1 && sentence[0] == ' ')
		cnt--;
	cout << cnt << '\n';
}