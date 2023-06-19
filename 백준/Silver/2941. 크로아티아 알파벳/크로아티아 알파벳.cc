#include<iostream>
#include<string>
using namespace std;

int main()
{
	string word;
	cin >> word;

	int num = 0;

	for (int i = 0; i < word.size(); i++)
	{
		if (word[i] == 'c')
		{
			if (word[i + 1] == '=' || word[i + 1] == '-')
			{
				num++;
				i++;
			}
			else
				num++;
		}
		else if (word[i] == 'd')
		{
			if (word[i + 1] == 'z' && word[i + 2] == '=')
			{
				num++;
				i = i + 2;
			}
			else if (word[i + 1] == '-')
			{
				num++;
				i++;
			}
			else
				num++;
		}
		else if (word[i] == 'l' && word[i + 1] == 'j')
		{
			num++;
			i++;
		}
		else if (word[i] == 'n' && word[i + 1] == 'j')
		{
			num++;
			i++;
		}
		else if (word[i] == 's' && word[i + 1] == '=')
		{
			num++;
			i++;
		}
		else if (word[i] == 'z' && word[i + 1] == '=')
		{
			num++;
			i++;
		}
		else
			num++;
	}
	cout << num << '\n';
}