#include<iostream>
#include <string>
#include<stdlib.h>
using namespace std;
class person 
{  
   protected:
	string name;
	int age;
	int IDnumber;
	
	void setname();
	void setage();
	void setidnum();
	void setdataperson();
	
	void printdataperson();
public:
	string getname();
	   int getage();
	   int getID();
	virtual double fee()=0;
};