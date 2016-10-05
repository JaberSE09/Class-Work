import java.util.ArrayList;


public class Driver {

	public static void main(String[] args) { 
		ArrayList<Animal> animals=new ArrayList<Animal>();
		Cat c=new Cat("cat 1");
		Cat c2=new Cat("cat 2");
		Dog d =new Dog("dog 1");
		Lizard l= new Lizard("Lizard 1");
		
		
		animals.add(d);
		animals.add(c);
		animals.add(c2);
		animals.add(l);
		
		
		int cat=0;
		int dog=0;
		int liz=0;
		for (int i = 0; i < animals.size(); i++) {
			
			if(animals.get(i) instanceof Cat){
			cat++;
			}
			if(animals.get(i) instanceof Dog){
				dog++;
			}
			if(animals.get(i) instanceof Lizard){
				liz++;
			}

		}
		
		System.out.println("There is " +animals.size());
		System.out.println("There are " +cat +" cats, " +dog+" dog and " +liz+" lizard");
		for (int i = 0; i < animals.size(); i++) {
			animals.get(i).speack();
			
			if(animals.get(i) instanceof Cat){
			Cat c1=(Cat) animals.get(i);
			System.out.println(c1.crawl(c1.name));
			System.out.println(c1.walk(c1.name));
			}
			if(animals.get(i) instanceof Dog){
				Dog c1=(Dog) animals.get(i);
				System.out.println(c1.crawl(c1.name));
				System.out.println(c1.walk(c1.name));
				}
			if(animals.get(i) instanceof Lizard){
				Lizard c1=(Lizard) animals.get(i);
				System.out.println(c1.crawl(c1.name));
				}
			if (animals.get(i) instanceof Cat) {
				Cat cat1= (Cat) animals.get(i);
				cat1.stalk(l.name);
			}
		}
		
	}

}

abstract class Animal{
	String name;
	Animal(String name){
		this.name=name;
		numAnimals++;
	}
abstract void speack();
void feed(String food){
    System.out.println("The " + name + " is munching on " + food + ".");
}
static int numAnimals;
static int getNumAnimals(){
	return numAnimals;
}
}

class Cat extends Animal implements Crawl,Walk{
	
	Cat(String name) {
		super(name);
	}

	public void stalk(String name2){
		System.out.println(name+"is stalking " + name2);
	}
	void speack() {
	    System.out.println("The cat says meow");
	}

	@Override
	public String walk(String name) {
		return name+" can walk.";
	}

	@Override
	public String crawl(String name) {
		return name+" can crawl.";
	}
	
}

class Dog extends Animal implements Crawl,Walk{

	Dog(String name) {
		super(name);
	}
	
	void speack() {
	    System.out.println("The dog says woof");
	}
	@Override
	public String walk(String name) {
		return name+" can walk.";
	}
	@Override
	public String crawl(String name) {
		return name+" can crawl.";
	}
}

class Lizard extends Animal implements Crawl{

	Lizard(String name) {
		super(name);
}
	void speack() {
	    System.out.println("The lizard says hiss");
	}
	@Override
	public String crawl(String name) {
		
		return name+" can crawl.";
	}	
}
interface Crawl{

	public abstract String crawl(String name);
}

interface Walk{
	public abstract String walk(String name);
}