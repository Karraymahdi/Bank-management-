#include"Person.h"
void person::setname()
{
	string x;
	cout << "name: ";
	cin >> x;
	this->name = x;
}
void person::setage()
{
	int a;
	cout << "age: ";
	cin >> a;
	this->age = a;
}
void person::setidnum()
{
	int x;
	cout << "ID number: ";
	cin >> x;
	this->IDnumber = x;
}
void person::setdataperson()
{
	setname();
	setage();
	setidnum();
}
void person::printdataperson()
{
	cout << "name:" << name << endl;
	cout << "AGE:" << age << endl;
	cout << "IDnumber:" << IDnumber << endl;
}
string person::getname() { return name; }
	   int person::getage() { return age; }
	   int person::getID() { return IDnumber; }
	   