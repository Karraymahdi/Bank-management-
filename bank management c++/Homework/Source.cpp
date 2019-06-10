#include<iostream>
#include<fstream>
#include <stdio.h>
#include <stdlib.h>
#include <string>
#include"person.h"
#include"employer.h"
#include"student.h"
using namespace std;
void Menu()
{
	cout << "Bank MENU" << endl;
	cout << "1:load exsting datebase" << endl;
	cout << "2:add new account "<< endl;
	cout << "3:delete account " << endl;
	cout << "4:modify account " << endl;
	cout << "5:Display data" << endl;
    cout << "6:Exit ";

}
int main()
{
	int nstudent = 0;
	int nemployer = 0;
	student *s = NULL;
	employer*e = NULL;
	int x = 16;


	do {
		Menu();
		int choice;
		cout << " your choice : ";
		cin >> choice;
		switch (choice)
		{
		case 1:
		{
			if (true)
			{
				ifstream reader("student.txt");
				try {
					if (reader.is_open())
					{
						reader >> nstudent;
						if (nstudent > 0)
						{
							s = new student[nstudent];
							for (int i = 0; i < nstudent; i++)
							{
								string name;
								int age;
								int IDnumber;
								double intialdeposit;
								string typecard;
								int banknumber;
								reader >> name >> age >> IDnumber >> intialdeposit >> typecard >> banknumber;
								s[i].getdatafromfile(name, age, IDnumber, intialdeposit, typecard, banknumber);
							}
							reader.close();
						}
						else
						{
							cout << " There is no data for students \n ";
						}
					}
					else
					{    
						ofstream writer("student.txt");
						writer << "0";
						nstudent = 0;
						writer.close();
						throw myex;
					}
				}
				catch (exception & e)
				{
					cout << e.what() << endl;
				}

				
			}
			if (true)
			{
				ifstream reader("employer.txt");
				if (reader.is_open())
				{
					reader >> nemployer;
					if (nemployer > 0)
					{
					
						e = new employer[nemployer];
						for (int i = 0; i < nemployer; i++)
						{
							string name;
							int age;
							int IDnumber;
							double intialdeposit;
							string typecard;
							int banknumber;
							reader >> name >> age >> IDnumber >> intialdeposit >> typecard >> banknumber;
							e[i].getdatafromfile(name, age, IDnumber, intialdeposit, typecard, banknumber);
						}

						reader.close();
						
						
					}
					else
					{
						cout << "There is no data for employers\n";
					}
				}
				else
				{
					ofstream writer("employer.txt");
					writer << "0" << endl;
					nemployer = 0;
					writer.close();
				}
			}
			
			break;
		}
		case 2:
		{
			cout << "Student : 1 / employer : 2  / 3 : EXIT              : ";
			int x;
			do {
				cin >> x;
			} while ((x != 1) && (x != 2) && (x != 3));
			if (x == 3) break;
			if (x == 1) {
				student *tmp = NULL, a;
				int i;
				tmp = new student[nstudent + 1];
				a.setstudentdata(nstudent);
				for (i = 0; i < nstudent; i++)
				{
					tmp[i] = s[i];
				}
				tmp[nstudent] = a;
				delete[] s;
				s = tmp;
				s[nstudent].print();
				nstudent++;
				system("pause");
			}
			else
			{
				employer *tmp = NULL, a;
				int i;
				cout << nemployer;
				tmp = new employer[nemployer + 1];
				a.setempolyerdata(nemployer);
				cout << nemployer;
				i = 0;
				for (i = 0; i < nemployer; i++)
				{
					tmp[i] = e[i];
				}
				tmp[nemployer] = a;
				delete[] e;
				e = tmp;
				e[nemployer].print();
				nemployer++;
				system("pause");
			}
			break;
		}
		case 3:
		{
			cout << "Student : 1/ employer : 2     /3 : EXIT            :  ";
			int x;
			do {
				cin >> x;
			} while ((x != 1) && (x != 2) && (x !=3));
			if (x == 3) break;
			if (x == 1)
			{

				student *tmp;
				cout << " Banknumber : ";
				int bnumber;
				cin >> bnumber;
				int i = 0;
				bool test = false;
				do
				{
					if (bnumber == s[i].getbanknumber())
						test = true;
					else i++;
				} while ((i < nstudent) && (test == false));
				if (test == true)
				{
					s[i].print();
					cout << "Do you want to delete this account 1 :  YES   2: NO    :";
					int w;
					do {
						cin >> w;
					} while ((w != 1) && (w != 2));
					if (w == 1)
					{
						tmp = new student[nstudent - 1];
						int v;
						for (v = 0; v < i; v++)
						{
							tmp[v] = s[v];
						}

						for (v = i + 1; v < nstudent; v++)
							tmp[v - 1] = s[v];
						delete[]s;
						s = tmp;
						nstudent--;
						system("pause");
						break;
					}
				}
				else
					cout << "This bank account doesn't exist " << endl;
				system("pause");
				break;

			}
			else
			{

				employer *tmp;
				cout << " Banknumber : ";
				int bnumber;
				cin >> bnumber;
				int i = 0;
				bool test = false;
				do
				{
					if (bnumber == e[i].getbanknumber())
						test = true;
					else i++;
				} while ((i < nemployer) && (test == false));
				if (test == true)
				{
					e[i].print();
					cout << "Do you want to delete this account 1 :  YES   2: NO    :";
					int w;
					do {
						cin >> w;
					} while ((w != 1) && (w != 2));
					if (w == 1)
					{
						tmp = new employer[nemployer - 1];
						int v;
						for (v = 0; v < i; v++)
						{
							tmp[v] = e[v];
						}

						for (v = i + 1; v < nemployer; v++)
							tmp[v - 1] = e[v];
						delete[]e;
						e = tmp;
						nemployer--;
						system("pause");
						break;
					}
				}
				else
					cout << "This bank account doesn't exist " << endl;
				system("pause");
				break;

			}
			break;
		}
		case 4 :
		{
			cout << "Student : 1/ employer : 2 / 3:EXIT                : ";
			int x;
			do {
				cin >> x;
			} while ((x != 1) && (x != 2) && (x != 3));
			if (x == 3) break;
			int bnumber;
			cout << " Banknumber : ";
			cin >> bnumber;
			if (x == 1)
			{
				int i = 0;
				bool test = false;
				do
				{
					if (bnumber == s[i].getbanknumber())
						test = true;
					else i++;
				} while ((i < nstudent) && (test == false));
				if (test == true)
				{
					int decide = 0;
					do {
						cout << "1 : deposit     2: Draw ";
						cin >> decide;
					} while ((decide != 1) && (decide != 2));
				if(decide == 1)
				{
					double x;
					cout << "DEPOSIT : ";
					cin >> x;
					s[i].modmoney(x);
				}
				else
				{
					double x;
					cout << "DRAW : ";
					cin >> x;
					if (x > s[i].getintialdeposit())
						cout << "Sorry, you don't have enough money " << endl;
					else 
					s[i].modmoney((-1*x));

				}

				}
				else
				{
					cout << "This bank account doesn't exist " << endl;
					system("pause");
				}

		}
			else
			{
				int i = 0;
				bool test = false;
				do
				{
					if (bnumber == e[i].getbanknumber())
						test = true;
					else i++;
				} while ((i < nemployer) && (test == false));
				if (test == true)
				{
					int decide = 0;
					do {
						cout << "1 : deposit     2: Draw ";
						cin >> decide;
					} while ((decide != 1) && (decide != 2));
					if (decide == 1)
					{
						double x;
						cout << "DEPOSIT : ";
						cin >> x;
						e[i].modmoney(x);
					}
					else
					{
						double x;
						cout << "DRAW : ";
						cin >> x;
						if (x > e[i].getintialdeposit())
							cout << "Sorry, you don't have enough money " << endl;
						else
							e[i].modmoney((-1 * x));

					}

				}
				else
				{
					cout << "This bank account doesn't exist " << endl;
					system("pause");
				}
			}
			break;
			}
		case 5:
		{    cout << "1:Display all students accounts" << endl;
		cout << "2:Display all empolyers accounts " << endl;
		cout << "3:Display a specific student account" << endl;
		cout << "4 :Display a specific employer account" << endl;
		cout << "5:EXIT " << endl;
		
		int choice;
		cin >> choice;
		switch (choice)
		{
		case 1:
		{	for (int i = 0; i < nstudent; i++)
			s[i].print();
			system("pause");
		break;
		}
		case 2:
		{
			for (int i = 0; i < nemployer; i++)
				e[i].print();
			system("pause");
			break;
		}
		case 3:
		{
			cout << " Banknumber : ";
			int bnumber;
			cin >> bnumber;
			int i = 0;
			bool test = false;
			do
			{
				if (bnumber == s[i].getbanknumber())
					test = true;
				else i++;
			} while ((i < nstudent) && (test == false));
			if (test == true)
			{
				s[i].print();
			}
			else
				cout << "This bank account doesn't exist " << endl;
			break;
		}
		case 4:
		{
			cout << " Banknumber : ";
			int bnumber;
			cin >> bnumber;
			int i = 0;
			bool test = false;
			do
			{
				if (bnumber == e[i].getbanknumber())
					test = true;
				else i++;
			} while ((i < nemployer) && (test == false));
			if (test == true)
			{
				e[i].print();
			}
			else
				cout << "This bank account doesn't exist " << endl;
			break;
		}
		case 5: {break; }
		}
		break;
		}
		case 6:
		{if (true)
		{
			remove("student.txt");
			ofstream writer("student.txt");
			writer << nstudent << endl;
			for (int i = 0; i < nstudent; i++)
			{
				writer << s[i].getname() << " ";
				writer << s[i].getage() << " ";
				writer << s[i].getID() << " ";
				writer << s[i].getintialdeposit() << " ";
				writer << s[i].gettypecard() << " ";
				writer << s[i].getbanknumber() << " ";
			}
			writer.close();

		}
		if (true)
		{
			remove("employer.txt");
			ofstream writer("employer.txt");
			writer << nemployer << endl;
			for (int i = 0; i < nemployer; i++)
			{
				writer << e[i].getname() << " ";
				writer << e[i].getage() << " ";
				writer << e[i].getID() << " ";
				writer << e[i].getintialdeposit() << " ";
				writer << e[i].gettypecard() << " ";
				writer << e[i].getbanknumber() << " ";
			}
			writer.close();
		}
		return 0;
		break;
		}
		}
		} while (!0);
	}