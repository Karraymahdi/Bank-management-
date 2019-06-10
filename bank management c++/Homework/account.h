#include<iostream>
#include <string>
#include<stdlib.h>
using namespace std; 
class account 
{ 
protected : 
	double intialdeposit;
	string typecard;
	int banknumber;

	void settypecard();
	void initialdepo();
	void setbanknumber(const int & n);
	void gettbanknumber();
	void printdataaccount();
	void setdataaccount(const int &n);
public: 
	string gettypecard();
	double getintialdeposit();
	int  getbanknumber();
	void modmoney(double x);

};
