#include"account.h"
void account::settypecard()
{
	string x;
	cout << "TYPE CARD: ";
	cin >> x;
	typecard = x;
}
void account::initialdepo()
{
	double x;
	cout << "DEPOSIT: ";
	cin >> x;
	this->intialdeposit = x;
}
void account::setbanknumber(const int & n)
{
	banknumber = banknumber + n + 1;
}
void account::gettbanknumber()
{
	cout << "banknumber";
	cout << banknumber;
}
void account::printdataaccount()
{
	cout << "card type :" << typecard << endl;
	cout << "balance :" << intialdeposit << " FT" << endl;
	cout << "bank number :" << banknumber << endl;
}
void account::setdataaccount(const int &n)
{
	settypecard();
	initialdepo();
	setbanknumber(n);
}
string account::gettypecard()
	{
		return typecard;
	}
	double account:: getintialdeposit()
	{
		return intialdeposit;
	}
	int account::getbanknumber()
	{
		return banknumber;
	}
	void account::modmoney(double x)
	{
		this->intialdeposit = intialdeposit + x;
	}