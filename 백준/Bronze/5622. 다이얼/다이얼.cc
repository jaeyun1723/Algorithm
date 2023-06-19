#include<iostream>
#include<string>
using namespace std;

int main()
{
	string src;
	cin >> src;
	int time = 0;
	
	for (int i = 0; i < src.size(); i++)
	{
		int k = (int)src[i];
		if (k >= 65 && k <= 67)
			time += 3;
		else if (k >= 68 && k <= 70)
			time += 4;
		else if (k >= 71 && k <= 73)
			time += 5;
		else if (k >= 74 && k <= 76)
			time += 6;
		else if (k >= 77 && k <= 79)
			time += 7;
		else if (k >= 80 && k <= 83)
			time += 8;
		else if (k >= 84 && k <= 86)
			time += 9;
		else if (k >= 87 && k <= 90)
			time += 10;
	}
	cout << time << '\n';
}