#include <iostream>
#include <malloc.h>
using namespace std;

int main(){
	int *a;
	a = (int*)malloc(sizeof(float));
	a[0] = 5;
	cout<<a[0];
	return 0;
}