
public class TestResultSet {
	
	int correct = 0;
	int incorrect = 0;
	int errors = 0;
	double precentage = 0;
		
	public TestResultSet(int correct, int incorrect, int errors, double precentage) {
		super();
		this.correct = correct;
		this.incorrect = incorrect;
		this.errors = errors;
		this.precentage = precentage;
	}
	
	public int getCorrect() {
		return correct;
	}
	public void setCorrect(int correct) {
		this.correct = correct;
	}
	public int getIncorrect() {
		return incorrect;
	}
	public void setIncorrect(int incorrect) {
		this.incorrect = incorrect;
	}
	public int getError() {
		return errors;
	}
	public void setError(int error) {
		this.errors = error;
	}
	public double getPrecentage() {
		return precentage;
	}
	public void setPrecentage(double precentage) {
		this.precentage = precentage;
	}

	@Override
	public String toString() {
		
		return "Results: \ncorrect = " + correct + "\nincorrect = " + incorrect + "\nerrors = " + errors + "\nprecentage = " + precentage;
	}
	
	
	
}
