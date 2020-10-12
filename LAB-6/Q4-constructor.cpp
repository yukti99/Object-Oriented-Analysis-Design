#include <bits/stdc++.h>
using namespace std;

class ABC{
	int x;
public:
	ABC(){
		cout<<"1";
	}
	~ABC(){
		cout<<"2";
	}

};
class KLM{
	int y;
	ABC O1;
public:
	KLM(){
		cout<<"3";
	}
	~KLM(){
		cout<<"4";
	}
};
class XYZ{
	int y;//XYZ O2; // this causes error - field ‘O2’ has incomplete type ‘XYZ’ i.e object of XYZ created before constructor declaration!
	ABC O3;
public:
	XYZ(){
		cout<<"5";
	}
	// destructor defined by the user 
	~XYZ(){
		cout<<"6";
	}
};
int main(){
	//Individually : class XYZ constructor & destructore is called but before that due to ABC O3 in class XYZ, 1 is printed first -> 1562
	// first their constructors called and then their destructors invoked 
	XYZ O4; 
	
	// prints nothing as its just a pointer to class KLM
	KLM *O6;

	// nothing printed
	XYZ *O5; 
	// object of class XYZ created
	// prints 15 -> constructors of XYZ and ABC
	O5 = new XYZ;

	//O6 = new XYZ; // ERROR -> cannot convert XYZ* to KLM* in assignment

	//prints 62
	delete(O5); // calls the destructor of class XYZ, then ABC because the object O3 also goes out of scope after XYZ is deleted 
	return 0;
}
/*
OUTPUT: 
if the two errors above are commented, the output will be:
but together all these statements will give output:
15156262 and not 15621562. this is what happens:
1. XYZ O4 calls ABC's constructore before XYZ's constructor -> 15 gets printed, none of these are out of scope yet, so destructors not called yet
2. KLM *O6 declares pointer to class KLM 
3. similiarly O5 is ponter to class XYZ
4. an of object of class XYZ  is instantiated -> so constructor of ABC and XYZ called printing-> 15 
5. in next line delete(O5) renders them out of scope object XYZ, so destructor of XYZ called ->6 and since XYZ destroyed, O3 also goes out of scope
so its destructor is also called->2
6. now return 0; cause the first to XYZ, ABC to go out of scope in same sequence as in 5) -> printing 62
so final output:
1 5 1 5 6 2 6 2
*/




