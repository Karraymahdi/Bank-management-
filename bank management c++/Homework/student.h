
class student : public person,public account,  public exception

{    
private:
	static string typeaccount; 
public: 
	virtual const char* what() const throw()
	{
		return " My exception has happend !";
	}
	double fee()
	{
		return 0.0;
	};
	student()
	{
		name = "----";
		age = 10;
		IDnumber = 0;
		intialdeposit = 0.0;
		typecard = "mastercard";
		banknumber = 17700000;
	}
	~student() {}
	void setstudentdata(const int & n)
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
}myex;
string student:: typeaccount = "junior";  
