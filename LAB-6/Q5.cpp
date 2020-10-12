#include <iostream>
#include <malloc.h>
using namespace std;

int main(){
	int *a[5];
	a[0] = (int*)malloc(sizeof(int));
	a[0][0] = 5;
	cout<<a[0][0]<<endl;
	return 0;
}