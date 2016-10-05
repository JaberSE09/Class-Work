
#include <iostream>
#include<stdlib.h>
#include<time.h>

using namespace std;

int main() {

	int num = 1000;
	int bet = 0;
	int guess = 0;
	cout << "Welcome to Dice Game." << endl;
	cout << "You have $1000.\n";
	bool done = false;
	char ans;
	while (done == false) {

		cout << "Roll dice: ";
		cin >> ans;
		if(ans=='n'){
			done=true;
			cout<<"Done";
		}

		if (ans == 'y') {

			srand (time(NULL));int result=rand()%6+1;
			cout<<"Your bet: ";
			cin>>bet;
			if(bet>num) {
				cout<<"You have: "<<num<<"Try again";
				cin>>bet;
			}
			if(num==0) {
				cout<<"You are broke";
				done=true;
			}
			cout<<"your guess: ";
			cin>>guess;
			if(guess==result) {
				cout<<"\nYou won "<<bet;
				cout<<endl;
				num+=bet;
			}

			else if(guess!=result) {
				cout<<"\nyou lost "<<bet;
				cout<<endl;
				num-=bet;
			}
		}
	}

	return 0;
}
