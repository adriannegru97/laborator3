package ro.usv.rf;

public class DistanceUtils {

	public static double calculateEuclidianDistance(double[] pattern1, double[] pattern2) {

		return Math.sqrt(Math.pow((pattern1[0] - pattern2[0]), 2) + Math.pow((pattern1[1] - pattern2[1]), 2));
	}

	public static double calculateMahalanobisDistance(double[] pattern1, double[] pattern2, double patternCount) {
		double sum = 0;
		for (int count = 0; count < pattern1.length; count++) {
			sum += Math.pow(pattern1[count] - pattern2[count], patternCount);
		}
		return Math.pow(sum, (1/patternCount));
	}

	public static double calculateCebisevDistance(double[] pattern1, double[] pattern2) {
		double max = Double.NEGATIVE_INFINITY;
		for (int count = 0; count < pattern1.length; count++) {
			max = Double.max(max, Math.abs(pattern1[count] - pattern2[count]));
		}
		return max;
	}

	public static double calculateCityBlock(double[] pattern1, double[] pattern2) {
		double sum = 0;
		for (int count = 0; count < pattern1.length; count++) {
			sum += Math.abs(pattern1[count] - pattern2[count]);
		}
		return sum;
	}
}

