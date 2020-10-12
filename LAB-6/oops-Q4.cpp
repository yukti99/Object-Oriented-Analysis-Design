#include <iostream>
#include <malloc.h>
using namespace std;

int main(){
	int *a;
	a[0] = (int*)malloc(sizeof(int));
	a[0] = 5;
	cout<<a[0]<<endl;
	return 0;
}