import java.util.ArrayList;


public class ArrayListSum {

	public static void main(String[] args) {


		int sum=0;
		ArrayList<Integer> list=new ArrayList<Integer>();
		list.add(5);
		list.add(12);
		list.add(8);
		list.add(10);
		list.add(3);
		list.add(4);
		list.add(11);
		for (int i = 0; i < list.size(); i++) {
			sum+=list.get(i);
		}
		System.out.println("Sajid ArrayList");
		System.out.println("list "+list);
		System.out.println("sum "+sum);
		System.out.println("average "+ sum/list.size());

	}

}
