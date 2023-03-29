// /**
// 	Name: Darelle Gochuico		Schedule: MW 3:00PM - 5:30PM

// 	A program that would accept two double values which represents, the opposite and the adjacent
// 	section of the triangle. Compute and display the area and perimeter. Display also the derived value
// 	of the hypotenuse.
// */

import java.util.Scanner;

public class Triangle{
	private double adjacent,opposite,hypotenuse;
	static public void main(String... args){
		double adjacent=0.0; 
		double opposite=0.0;
		double hypotenuse=0.0;
		try{
			Scanner input=new Scanner(System.in);
			System.out.print("-- program start --\n\nEnter Opposite(n):");
			adjacent=input.nextDouble();
			System.out.print("Enter Adjacent(n):");
			opposite=input.nextDouble();
			System.out.print("Enter Hypotenuse(n):");
			hypotenuse=input.nextDouble();

			Triangle tri = new Triangle(adjacent,opposite,hypotenuse);
			System.out.println(tri);
			System.out.println("-- program ends --");
		}
		catch(Exception e){
			//user defined exception message
			System.out.println("Input Error !!");
		}
	}

	public Triangle(double adjacent,double opposite,double hypotenuse){
		this.adjacent=adjacent;
		this.opposite=opposite;
		this.hypotenuse=hypotenuse;
	}
	//default constructor
	public Triangle(){
		this(1,1,1); //invoke the previously defined constructor
	}
	//method to compute the area
	public double computeArea(){
		return adjacent * opposite / 2;
	}
	//method to compute the perimeter
	public double computePerimeter(){
		return adjacent + opposite + hypotenuse;
	}
	//override the toString() <-convert the properties of the object to a String
	public String toString(){
		return "Area      :"+computeArea()
			+"\nPerimeter :"+computePerimeter();
	}
}//end of class