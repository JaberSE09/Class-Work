import java.util.ArrayList;
import java.util.Scanner;


public class ArrayListProblem {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int x=0;
		int sum=0;
		ArrayList<Integer> list=new ArrayList<Integer>();
		
		System.out.print("Enter numbers ");
		do{
			try {
				x=s.nextInt();
			} catch (Exception e) {
				x-=x;
				System.out.println("try again");
				x=s.nextInt();
			}
			if(x<0){
				break;
			}
			else{
				sum+=x;
				list.add(x);
			}
		}while(x>0);
		System.out.println(list);
		System.out.println(sum);
		System.out.print("Search for a number: ");
		int y=s.nextInt();
		for (int i = 0; i < list.size(); i++) {
			if(y==list.get(i)){
				System.out.println("Found");
				break;
			}
			else if(i==list.size()-1){
				System.out.println("Not found");
			}
	}
		s.close();
	}
}
