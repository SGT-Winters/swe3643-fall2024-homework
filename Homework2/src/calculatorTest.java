import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class calculatorTest {

    @Test
    void computeMean() {
        List<Double> valuesList = Arrays.asList(10.0, 20.0, 30.0);
        double expectedMean = 20.0;
        double actualMean = calculator.computeMean(valuesList);
        assertEquals(expectedMean, actualMean, 0.0001);
    }

    @Test
    void computeSquareOfDifferences() {
        List<Double> valuesList = Arrays.asList(2.0, 4.0, 6.0);
        double mean = 4.0;
        double expectedSumOfSquares = 8.0; // (2^2 + 0^2 + 2^2) = 4 + 0 + 4 = 8
        double actualSumOfSquares = calculator.computeSquareOfDifferences(valuesList, mean);
        assertEquals(expectedSumOfSquares, actualSumOfSquares, 0.0001);
    }

    @Test
    void computeVariance() {
        double squareOfDifferences = 8.0;
        int numValues = 3;
        boolean isPopulation = false;
        double expectedVariance = 4.0; // (8 / (3 - 1))
        double actualVariance = calculator.computeVariance(squareOfDifferences, numValues, isPopulation);
        assertEquals(expectedVariance, actualVariance, 0.0001);
    }

    @Test
    void computeStandardDeviation() {
        List<Double> valuesList = Arrays.asList(9.0, 6.0, 8.0, 5.0, 7.0);
        boolean isPopulation = false; // Indicates sample standard deviation
        double expectedStdDev = 1.5811;
        double actualStdDev = calculator.computeStandardDeviation(valuesList, isPopulation);
        assertEquals(expectedStdDev, actualStdDev, 0.0001, "Sample standard deviation does not match expected value");
    }

    @Test
    void computeSampleStandardDeviation() {
        List<Double> valuesList = Arrays.asList(9.0, 6.0, 8.0, 5.0, 7.0);
        double expectedStdDev = 1.5811;
        double actualStdDev = calculator.computeSampleStandardDeviation(valuesList);
        assertEquals(expectedStdDev, actualStdDev, 0.0001);
    }

    @Test
    void computePopulationStandardDeviation() {
        List<Double> valuesList = Arrays.asList(
                9.0, 2.0, 5.0, 4.0, 12.0, 7.0, 8.0, 11.0, 9.0, 3.0,
                7.0, 4.0, 12.0, 5.0, 4.0, 10.0, 9.0, 6.0, 9.0, 4.0
        );
        double expectedStdDev = 2.9833;
        double actualStdDev = calculator.computePopulationStandardDeviation(valuesList);
        assertEquals(expectedStdDev, actualStdDev, 0.0001);
    }
}