
public class lab5 {
	static int counter=0;
	static int digit=0;
	static int stringtoint(String num){
		
		if(counter<num.length()){
			digit*=10;
			digit+=(num.charAt(counter) -'0');
			counter++;
			return stringtoint(num);
		}
		else return digit;
	}
	static int counter2=0;
	static String hold="";
	static String duplicate(String num){
		String split[]=num.split("");
		if(counter2<num.length()-1){
			hold+=split[counter2];
			hold+=split[counter2];
			counter2++;
			return duplicate(num);
		}
		else return hold;
	}

	static int bin=0;
	static int bin2=0;
	static String hold2="";
	static String binary(int num){
		if(num>0){
			bin=num%2;
			num=num/2;
			hold2+=bin;
			return binary(num);
		}
		else return hold2;
	}
	
	
public static void main(String[] args){
	
	System.out.println(stringtoint("123"));
	System.out.println(duplicate("12345"));
	System.out.println(binary(5));
}

}