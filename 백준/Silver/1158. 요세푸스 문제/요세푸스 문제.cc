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
		for (int i = 0; i < N; i++) {
			Que[i] = i + 1;
		}
		f = 0;
		r = 0;
		n = N;
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
		else return Que[(r - 1 + MAX) % MAX];
	}

	void enqueue(int x)
	{
		if (size() == MAX)
			cout << "Queue Overflow" << '\n';
		else
		{
			Que[r] = x;
			r = (r + 1) % MAX;
			n += 1;
		}
	}

	int dequeue()
	{
		if (empty()) return -1;
		else {
			int temp = Que[f];
			f = (f + 1) % MAX;
			n -= 1;
			return temp;
		}
	}
		
};

int main() {
	int n;
	cin >> n;
	int c;
	cin >> c;
	int k;
	Queue jsp(n);
	cout << "<";
	while (jsp.size() != 1)
	{
		for (int i = 0; i < c-1; i++)
		{
			k = jsp.dequeue();
			jsp.enqueue(k);
		}
		cout << jsp.front() << ", ";
		jsp.dequeue();
	}
	cout << jsp.front() << ">";
}