/* Class has written to parse The Iris Data Set only! */ 

import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.LinkedList;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.math3.linear.ArrayRealVector;

public class IrisCSVPars {	
	
	private LinkedList<ArrayRealVector> parsedVectors = new LinkedList<ArrayRealVector>();
	private LinkedList<String> labelResultSet = new LinkedList<String>();
	private LabelSet<String> labelSet = new LabelSet<String>();

	public IrisCSVPars(String path) 
	{		
		try 
		{			
			Reader in = new FileReader(path);	
			Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(in);	
			for (CSVRecord record : records)
			{				
				ArrayRealVector newRecord = new ArrayRealVector(record.size() - 1);
				for(int i = 0; i < record.size() - 1; i++)				
					newRecord.setEntry(i, Double.parseDouble(record.get(i)));				
				parsedVectors.add(normalize(newRecord));
				labelResultSet.add(record.get(record.size()-1));
				addLabelToList(record.get(record.size()-1));													
			}	
			System.out.println("All labels: " + labelSet);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	LinkedList<ArrayRealVector> getParsedVectors()
	{
		return parsedVectors;
	}	
	
	ArrayRealVector normalize(ArrayRealVector normalizedVec)
	{	
		double length = normalizedVec.getNorm();		
		return (ArrayRealVector)normalizedVec.mapDivide(length);
	}
	
	void addLabelToList(String newLabel)
	{
		System.out.println("label: " + newLabel);
		boolean valueExists = false;
		for(String label : labelSet)
		{
			if(label.equals(newLabel))
				valueExists = true;			
		}
		if(valueExists == false)
			labelSet.add(newLabel);		
	}

	//g&s
	public LabelSet<String> getLabels() {
		return labelSet;
	}

	public LinkedList<String> getLabelResultSet() {
		return labelResultSet;
	}
	
}
