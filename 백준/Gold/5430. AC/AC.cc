#include<iostream>
#include<string>
#include<vector>
#include<cmath>
#include<algorithm>
#include<stack>
#include<queue>
#include<map>
#include<deque>
using namespace std;

deque <int> dq;

void showinfo(bool flag)
{
	cout << "[";
	if (dq.size() != 0)
	{
		if (flag == false)
		{
			for (int i = 0; i < dq.size() - 1; i++)
				cout << dq[i] << ",";
			cout << dq[dq.size() - 1];
		}
		else
		{
			for (int i = dq.size() - 1; i > 0; i--)
				cout << dq[i] << ",";
			cout << dq[0];
		}
	}
	cout << "]\n";
}

int main() {
	int T;
	cin >> T;
	while (T--)
	{
		string func, list;
		int n;
		cin >> func >> n >> list;
		string num = "";
		bool flag = false;
		bool err = false;
		if (n != 0)
		{
			for (int i = 1; i < list.size(); i++)
			{
				if (list[i] >= '0' && list[i] <= '9')
					num += list[i];
				else
				{
					if (num != "")
					{
						dq.push_back(stoi(num));
						num = "";
					}
				}
			}
		}
		for (int i = 0; i < func.size(); i++)
		{
			if (func[i] == 'R')
				flag = !flag;
			if (func[i] == 'D')
			{
				if (dq.empty())
				{
					cout << "error" << '\n';
					err = true;
					break;
				}
				if (!flag)
					dq.pop_front();
				else
					dq.pop_back();
			}
		}
		if (!err)
			showinfo(flag);
		dq.clear();
	}
}