package onePackage;

class World{
	//instance variable
	String s1 = "World";	
	
	//parent class method
	void prentClassMethod() {
		System.out.println("Paret class Method");
	}
	
	//parent class constructor
	World(){
		System.out.println("Parent class Constructor");
	}
}

class India extends World{
	//child class instance variable
	String s2 = "India";
	
	//Method for access parent and child class instance variable
	void accessParentClassInstanceVariable() {
		System.out.println("Parent class Instance variable: "+super.s1);
		System.out.println("Child class Instance variable: "+s2);
	}
	
	//child class method and access super class method
	void childClassMethod() {
		super.prentClassMethod();
		System.out.println("Child class Method");
	}
	
	//Child class constructor
	India(){
		super();
		System.out.println("Child class Constructor");
	}
}

public class SuperKeyword{

	public static void main(String args[]) {
		
		India i = new India();
		System.out.println("");
		
		i.accessParentClassInstanceVariable();
		System.out.println("");
		
		i.childClassMethod();
	}
}
