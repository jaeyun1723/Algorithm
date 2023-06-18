#include<iostream>
#include<string>
using namespace std;

int main()
{
	int alphabet[26] = { 0, };
	string word;
	cin >> word;

	for (int i = 0; i < word.size(); i++)
	{
		if (word[i] >= 'A' && word[i] <= 'Z')
		{
			alphabet[word[i] - 65]++;
		}
		if (word[i] >= 'a' && word[i] <= 'z')
		{
			alphabet[word[i] - 97]++;
		}
	}
	int max = 0;
	int idx;
	for (int i = 0; i < 26; i++)
	{
		if (max < alphabet[i])
		{
			max = alphabet[i];
			idx = i;
		}
	}
	bool flag = false;
	for (int i = 0; i < 26; i++)
	{
		if (max == alphabet[i])
		{
			if (flag == true)
			{
				cout << "?" << '\n';
				return 0;
			}
			else
				flag = true;
		}
	}
	cout << char(idx + 65) << '\n';
}