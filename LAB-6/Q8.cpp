#include <iostream>
#include <malloc.h>
using namespace std;

int main(){
	int *a = (int*)malloc(5*sizeof(int));
	a[0] = 1;
	a[1] = 2;
	a[2] = 3;
	a[3] = 4;
	a[4] = 5;
	delete(a);
	cout<<a[0]<<endl;
	cout<<a[1]<<endl;
	cout<<a[2]<<endl;
	cout<<a[3]<<endl;
	cout<<a[4]<<endl;
	//cout<<a[0]<<a[1]<<a[2]<<a[3]<<a[4];
	return 0;
}