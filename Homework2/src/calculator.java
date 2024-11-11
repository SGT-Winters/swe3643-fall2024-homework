import java.util.Arrays;
import java.util.List;

public class calculator {

    static void run(){
        // Sample standard deviation calculation
        List<Double> sampleValuesList = Arrays.asList(9.0, 6.0, 8.0, 5.0, 7.0);
        double sampleStdDev = calculator.computeSampleStandardDeviation(sampleValuesList);
        System.out.println("Sample StdDev = " + sampleStdDev);
        // Expected output: Sample StdDev=1.5811388300841898

        // Population standard deviation calculation
        List<Double> populationValuesList = Arrays.asList(
                9.0, 2.0, 5.0, 4.0, 12.0, 7.0, 8.0, 11.0, 9.0, 3.0,
                7.0, 4.0, 12.0, 5.0, 4.0, 10.0, 9.0, 6.0, 9.0, 4.0
        );
        double popStdDev = calculator.computePopulationStandardDeviation(populationValuesList);
        System.out.println("Population StdDev = " + popStdDev);
        // Expected output: Population StdDev=2.9832867780352594
    }

    // Function to compute the mean (average) of a list of values
    public static double computeMean(List<Double> valuesList) {
        if (valuesList == null || valuesList.isEmpty()) {
            throw new IllegalArgumentException("valuesList parameter cannot be null or empty");
        }

        double sumAccumulator = 0.0;
        for (double value : valuesList) {
            sumAccumulator += value;
        }

        return sumAccumulator / valuesList.size();
    }

    // Function to compute the sum of squared differences from the mean
    public static double computeSquareOfDifferences(List<Double> valuesList, double mean) {
        if (valuesList == null || valuesList.isEmpty()) {
            throw new IllegalArgumentException("valuesList parameter cannot be null or empty");
        }

        double squareAccumulator = 0.0;
        for (double value : valuesList) {
            double difference = value - mean;
            double squareOfDifference = difference * difference;
            squareAccumulator += squareOfDifference;
        }

        return squareAccumulator;
    }

    // Function to compute the variance based on squared differences
    public static double computeVariance(double squareOfDifferences, int numValues, boolean isPopulation) {
        // Adjust number of values for sample standard deviation
        if (!isPopulation) {
            numValues -= 1;
        }

        if (numValues < 1) {
            throw new IllegalArgumentException("numValues is too low (sample size must be >= 2, population size must be >= 1)");
        }

        return squareOfDifferences / numValues;
    }

    // Function to compute the population or sample standard deviation from a list of values
    public static double computeStandardDeviation(List<Double> valuesList, boolean isPopulation) {
        if (valuesList == null || valuesList.isEmpty()) {
            throw new IllegalArgumentException("valuesList parameter cannot be null or empty");
        }

        double mean = computeMean(valuesList);
        double squareOfDifferences = computeSquareOfDifferences(valuesList, mean);
        double variance = computeVariance(squareOfDifferences, valuesList.size(), isPopulation);

        return Math.sqrt(variance);
    }

    // Function to compute the sample standard deviation from a list of values
    public static double computeSampleStandardDeviation(List<Double> valuesList) {
        return computeStandardDeviation(valuesList, false);
    }

    // Function to compute the population standard deviation from a list of values
    public static double computePopulationStandardDeviation(List<Double> valuesList) {
        return computeStandardDeviation(valuesList, true);
    }
}
