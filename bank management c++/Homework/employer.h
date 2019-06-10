#include"account.h"
class employer : public person ,public account 
{
	static string typeaccount;
public : 
	double fee()
	{
		return (300 + (intialdeposit*0.01));
	}
	void setempolyerdata(const int & n)
	{
		setdataperson();
		setdataaccount(n);

	}
	void print() {
		printdataperson();
		printdataaccount();
		cout << "type account :" << typeaccount << endl;
		cout << "fee :" << fee() << " FT" << endl;
	}
	void getdatafromfile(string name, int age, int IDnumber, double intialdeposit, string typecard, int banknumber)
	{
		this->name = name;
		this->age = age;
		this->IDnumber = IDnumber;
		this->intialdeposit = intialdeposit;
		this->typecard = typecard;
		this->banknumber = banknumber;
	}
	
	employer()
	{
		name = "----";
		age = 10;
		IDnumber = 0;
		intialdeposit = 0.0;
		typecard = "VISA";
		banknumber = 200000000;
	}
	~employer() {}
};
string employer::typeaccount = "Adult";
