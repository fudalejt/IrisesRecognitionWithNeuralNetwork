import java.util.ArrayList;
import java.util.LinkedList;

import org.apache.commons.math3.linear.ArrayRealVector;

public class NeuronNetwork {
	
	private ArrayList<Neuron> neuronArray;
	
	public NeuronNetwork(int neuronCount, int inputsCount) 
	{	
		neuronArray  = new ArrayList<Neuron>(neuronCount);	
		for(int i = 0; i < neuronCount; i++)
		{
			neuronArray.add(i, new Neuron(inputsCount, i));			
		}			
	}	
	
	public void create(int neuronCount, int inputsCount)
	{
		neuronArray  = new ArrayList<Neuron>(neuronCount);	
		for(int i = 0; i < neuronCount; i++)
		{
			neuronArray.add(i, new Neuron(inputsCount, i));			
		}			
	}
	
	public void teachNeurons(ArrayRealVector input)
	{	
		for(Neuron n : neuronArray) //set an input of all neurons 
		{
			n.setInputValue(input);
		}	
		int winner = getMaxOutputIndex(); //indicate an index of the neuron with the biggest output
		neuronArray.get(winner).teach(0.1f, input); //teach the winner only		
		
		System.out.println("winner = " + winner);	
	}
	
	public void setInputVector(ArrayRealVector inputVector)
	{
		for(Neuron n : neuronArray) //set an input of all neurons 
		{
			n.setInputValue(inputVector);
		}		
	}
	
	public int getSize(){
		return neuronArray.size();
	}
	
	public int getMaxOutputIndex()
	{
		int index = 0;
		int j = 0;
		for(Neuron neuron: neuronArray)
		{
			if(neuron.getOutput() > neuronArray.get(index).getOutput())
			{
				index = j;
			}
			j++;
		}		
		return index;		
	}

	public ArrayList<Neuron> getNeuronArray() {
		return neuronArray;
	}		
	
	public Neuron getNeuron(int index)
	{
		return neuronArray.get(index);
	}
	
	public Neuron getWinner()
	{
		return neuronArray.get(getMaxOutputIndex());
	}
}


