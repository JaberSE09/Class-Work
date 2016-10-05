class MyNumType implements Comparable{
public int valu;
MyNumType(int v){ valu = v;}

public boolean equals(Object o){
if (!(o instanceof MyNumType)) return false;
MyNumType a = (MyNumType)o;
return valu == a.valu;
}

public int compareTo(Object arg0) {
MyNumType a = (MyNumType)arg0;
if (valu < a.valu) return -1;
if (valu > a.valu ) return +1;
return 0;
}
}

public class Main {

public static void main(String[] args){

Integer five = new Integer(5);
Integer three = new Integer(3);
Integer other = new Integer(3);

System.out.println(five.compareTo(three));
System.out.println(three.compareTo(five));
System.out.println(three.compareTo(other));

MyNumType one = new MyNumType(1);
MyNumType two = new MyNumType(2);
System.out.println(one.equals(two));
System.out.println(one.compareTo(two));
System.out.println(two.compareTo(one));

}

}