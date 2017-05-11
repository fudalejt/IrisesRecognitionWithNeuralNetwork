
public class Main {

	public static void main(String[] args) {
		IrisCSVPars parser = new IrisCSVPars("iris.data");
		LearningNetwork learningNetwork = new LearningNetwork(300, 0.1d, parser.getParsedVectors(), parser.getLabelResultSet());
		learningNetwork.learn(100);
		learningNetwork.assignLabels(parser.getLabels());
		learningNetwork.testNetwork(1);
		
		System.out.println(learningNetwork.testNetwork(1));
		
		
	}
}
