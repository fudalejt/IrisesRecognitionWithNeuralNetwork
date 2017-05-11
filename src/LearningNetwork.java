import java.util.ArrayList;
import java.util.LinkedList;

import org.apache.commons.math3.linear.ArrayRealVector;

public class LearningNetwork {
	
	private LinkedList<ArrayRealVector> inputVectors;
	private LinkedList<String> labelResultSet;
	private NeuronNetwork neuronNetwork;
	
	
	public LearningNetwork(int neurons, double learingFactor, LinkedList<ArrayRealVector> inputVectors, LinkedList<String> labelResultSet)
	{
		this.inputVectors = inputVectors;	
		this.labelResultSet = labelResultSet;
		neuronNetwork = new NeuronNetwork(neurons, inputVectors.getFirst().getDimension());
	}
	
	void learn(int ages)
	{
		for(int i = 0; i < ages; i++)
		{
			for(ArrayRealVector input : inputVectors)
				neuronNetwork.teachNeurons(input);
		}		
	}
		
	void assignLabels(LabelSet<String> labelList)
	{
		int[][] neuTimesLabel = new int[neuronNetwork.getSize()][labelList.size()];		
		int i = 0;
		for(ArrayRealVector input : inputVectors)
		{
			neuronNetwork.setInputVector(input); //set the output
			int neuronIndex = neuronNetwork.getMaxOutputIndex(); //get an index of the winner neuron			
			String labelOfInput = labelResultSet.get(i); //get a correct label result			
			int labelNumber = labelList.getIndex(labelOfInput);
			neuTimesLabel[neuronIndex][labelNumber]++;			
			i++;			
		}
		
		for(int j = 0; j < neuronNetwork.getNeuronArray().size(); j++)
		{
			int index = -1;
			int max = 0;
			for(int k = 0; k < labelList.size(); k++)
			{
				if(neuTimesLabel[j][k] > max)	
				{
					max = neuTimesLabel[j][k];
					index = k;
				}
			}
			if(max > 1)			
				neuronNetwork.getNeuron(j).setLabel(labelList.get(index));			
		}
		
		int z = 0;		
		for(int[] iv : neuTimesLabel){
			
			for(int in : iv){
				System.out.print(in + " ");
			}				
			System.out.println(neuronNetwork.getNeuron(z).getLabel());
			z++;
		}			
	}	
	
	TestResultSet testNetwork(float sampling)//e.g. sampling = 2 means: take every second row
	{
		int correct = 0;
		int incorrect = 0;
		int error = 0;		
		if(sampling <= 1 && sampling > 0)
		{			
			float counter = 0;
			int i = 0;
			for(ArrayRealVector input : inputVectors)
			{
				neuronNetwork.setInputVector(input);
				Neuron winner = neuronNetwork.getWinner();
				if(winner.getLabel() != null && winner.getLabel().equals(labelResultSet.get(i)))
					correct++;
				else if(winner.getLabel() != null)
					incorrect++;
				else 
					error++;
			}				
		}		
		TestResultSet results;
		return results = new TestResultSet(correct, incorrect, error, (float)correct/incorrect * 100.f);
		
	}
}
