package ro.usv.rf;

public class MainClass {
	
	
	public static void main(String[] args) {
		double[][] learningSet;
		try {
			learningSet = FileUtils.readLearningSetFromFile("in.txt");
			int numberOfPatterns = learningSet.length;
			int numberOfFeatures = learningSet[0].length;
			System.out.println(String.format("The learning set has %s patters and %s features", numberOfPatterns, numberOfFeatures));
			for (int count = 1; count < learningSet.length; count++) {
				double euclidianDistance = DistanceUtils.calculateEuclidianDistance(learningSet[0], learningSet[count]);
				System.out.println("Euclidian Distance between form 0 and form " + count + " is " + euclidianDistance);
				
				double cebisevDistance = DistanceUtils.calculateCebisevDistance(learningSet[0], learningSet[count]);
				System.out.println("Cebisev Distance between form 0 and form " + count + " is " + cebisevDistance);
				
				double cityBlock = DistanceUtils.calculateCityBlock(learningSet[0], learningSet[1]);
				System.out.println("City Block distance between form 0 and form " + count + " is " + cityBlock);
				
				double mahalanobisDistance = DistanceUtils.calculateMahalanobisDistance(learningSet[0], learningSet[1], learningSet[0].length);
				System.out.println("Mahalanobis Distance between form 0 and form " + count + " is " + mahalanobisDistance);
				
			}
		} catch (USVInputFileCustomException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Finished learning set operations");
		}
	}

}
