import java.util.Random;

import org.apache.commons.math3.linear.ArrayRealVector;


public class Neuron {
	
	static Random random = new Random();
	
	private ArrayRealVector theta; //theta is a weight vector
	private double output;
	private int number;
	private String label;
		
	public Neuron(int inputsCount, int number) 
	{
		this.number = number;
		theta = new ArrayRealVector(inputsCount);
		for(int i = 0; i < theta.getDimension(); i++)
		{
			theta.setEntry(i, (random.nextDouble() * 2) - 1);
		}
		System.out.println("theta = " + theta);
	}
	
	double setInputValue(ArrayRealVector X) //X - input vector
	{ 				
		if(X.getDimension() == theta.getDimension()){
			return output = theta.dotProduct(X);
		}
		else return 0.d; //maybe exception?		
	}

	ArrayRealVector teach(double alfa, ArrayRealVector X)
	{		
		if(X.getDimension() == theta.getDimension()){
			theta = theta.add((X.subtract(theta)).mapMultiply(alfa)); 
			System.out.println("theta = " + theta);
			return theta;
		}
		else return null;		
	}

	public double getOutput() {
		return output;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
		
}
