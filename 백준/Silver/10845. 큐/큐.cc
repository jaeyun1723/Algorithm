#include<iostream>
#include<string>
using namespace std;

class Queue {
public:
	int f;
	int r;
	int n;
	int MAX;
	int* Que;

	Queue(int N)
	{
		MAX = N;
		Que = new int[N];
		f = 0;
		r = 0;
		n = 0;
	}

	int size()
	{
		return n;
	}

	int empty()
	{
		if (size() == 0) return 1;
		else return 0;
	}

	int front()
	{
		if (empty()) return -1;
		else return Que[f];
	}

	int back()
	{
		if (empty()) return -1;
		else return Que[r - 1];
	}

	void push(int x)
	{
		{
			Que[r] = x;
			r = (r + 1);
			n += 1;
		}
	}

	int pop()
	{
		if (empty()) return -1;
		else {
			int temp = Que[f];
			f = f + 1;
			n -= 1;
			return temp;
		}
	}
};

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	Queue Qu(10000);
	int k;
	cin >> k;
	for (int i = 0; i < k; i++)
	{
		string qus;
		cin >> qus;
		if (qus == "push")
		{
			int m;
			cin >> m;
			Qu.push(m);
		}
		else if (qus == "front")
			cout << Qu.front() << '\n';
		else if (qus == "back")
			cout << Qu.back() << '\n';
		else if (qus == "size")
			cout << Qu.size() << '\n';
		else if (qus == "empty")
			cout << Qu.empty() << '\n';
		else if (qus == "pop")
			cout << Qu.pop() << '\n';
	}
}