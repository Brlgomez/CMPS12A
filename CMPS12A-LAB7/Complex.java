
public class Complex {
	public double real, imaginary; //declaring more variables
	
	/*
	 * constructor
	 */
	
	public Complex  (double real, double imaginary){
		this.real = real;
		this.imaginary = imaginary;
	}
	
	// this setValue method is deprecated and its use is discouraged
	// it is cleaner to create new Complex numbers
	// with the right value using the constructor above
	
	public void setValue(double real, double imaginary){
		this.real = real;
		this.imaginary = imaginary;
	}
	
	/*
	 * Adds real with real and imaginary with imaginary:
	 * (x + i) + (y + i)
	 * puts the numbers into a new Complex.
	 * prints 
	 */
	
	public Complex add(Complex other){
		double r = this.real + other.real;
		double i = this.imaginary + other.imaginary; 
		Complex nu = new Complex(r,i);
		System.out.println("Adding both complex numbers");
		print(nu);
		System.out.println();
		return nu;
	}
	
	/*
	 * Multiplies real with real and imaginary with imaginary:
	 * (x + i) * (y + i)
	 * puts the numbers into a new Complex.
	 * prints 
	 */
	
	public Complex mulitply(Complex other){
		double r = this.real*other.real - (this.imaginary*other.imaginary);
		double i = this.imaginary*other.real + this.real*other.imaginary;
		Complex nu = new Complex(r,i);
		System.out.println("Multipling both complex numbers:");
		print(nu);
		System.out.println();
		return nu;
	}
	
	/*
	 * Uses the Math package to find the absolute value of the complex number.
	 */
	
	public double absValue(){
		double abs = Math.sqrt(this.real*this.real + this.imaginary*this.imaginary);
		return abs;
	}
	
	/*
	 * prints the real and imaginary. 
	 */
	
	public void print(Complex other){
		System.out.print("Real value: " + other.real);
		System.out.print(" Imaginary value: " + other.imaginary);
	}
}
