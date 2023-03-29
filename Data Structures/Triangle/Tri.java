import java.lang.*; import java.math.*;

public class Tri{
	private double length,width;

	static public void main(String... args){ // public = public modifier, static = static modifier
		try{
			System.out.print("-- Program Start --\n\nEnter length(n): "); // this is a prompt
			double length =  new java.util.Scanner(System.in).nextDouble();
			System.out.print("Enter width(n): "); //this is a prompt
			double width = new java.util.Scanner(System.in).nextDouble();

			Tri tri = new Tri(length,width);
			System.out.println(tri);
			System.out.println("\n-- program end --");
		}catch(Exception e){
			System.out.println("Input Error");
		}
	}// end of main; could be used or copied in Rectangle.java

	public Tri(double length,double width){ // this is a constructor
		this.length = length;
		this.width = width;
	}

	//default constructor
	public Tri(){
		this(1,1); //invokes the previously defined constructor
	}

	//method to compute the area
	public double computeArea(){
		return ((1 * length)/2) * width;
	}

	//method to compute the hypotenuse
	public double computeHypotenuse(){
		return Math.sqrt((length*length)+(width*width));
	}

	//method to compute the perimeter
	public double computePerimeter(){
		return length+width+computeHypotenuse();
	}

	//override the toString() <-- converts the properties of the object to a String
	public String toString(){
		return "Area: " + computeArea() + "\nPerimeter : " + computePerimeter();
	}

}// end of class
