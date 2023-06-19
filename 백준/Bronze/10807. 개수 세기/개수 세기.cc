#include<iostream>
using namespace std;

int main(){
    int N,num;
    int arr[201]={0,};
    cin>>N;
    for(int i=0;i<N;i++){
        cin>>num;
        arr[num+100]++;
    }
    int res;
    cin>>res;
    cout<<arr[res+100]<<'\n';
}