import nz.ac.vuw.kol.OptimisationFunction;

import java.util.Random;

/**
 * Created by Julian on 9/01/2018.
 */
public class Chromosome {

    private double[] values;
    private double fitness;

    public Chromosome() {
        randomiseValues();
    }

    public double[] getValues() {
        return values;
    }

    public double getFitness() {
        return fitness;
    }

    public void setValues(double[] values) {
        this.values = values;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    public void calculateFitness() {
        OptimisationFunction.unknownFunction(values);
    }

    //Method used to randomise a set of double[] for use within the fitness function
    public void randomiseValues() {

        Random randomGenerator = new Random();

        values = new double[5];

        for (int i = 0; i < values.length; i++) {

            double random = randomGenerator.nextDouble() * Double.MAX_VALUE;

            if (randomGenerator.nextBoolean()) {
                random = -random;
            }

            values[i] = random;
        }
    }

    public void printValues() {

        for (int i = 0; i < values.length; i++) {

            System.out.println(values[i] + " ");

        }
    }
}
