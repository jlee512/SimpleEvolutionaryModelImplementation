import nz.ac.vuw.kol.OptimisationFunction;

import java.util.Random;

/**
 * Created by Julian on 9/01/2018.
 */
public class Chromosome {

    private double[] values;
    private double fitness;

    public Chromosome(double max, double min) {
        randomiseValues(max, min);
        calculateFitness();
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
        fitness = OptimisationFunction.unknownFunction(values);
    }

    //Method used to randomise a set of double[] for use within the fitness function
    public void randomiseValues(double max, double min) {

        values = new double[5];

        for (int i = 0; i < values.length; i++) {

            values[i] = Math.random() * (max - min) + min;
        }
    }

    public void printValues() {

        System.out.print("Values: ");
        for (int i = 0; i < values.length; i++) {

            System.out.print(values[i] + " ");

        }
        System.out.println();
    }

    public void printFitness() {

        System.out.println("Fitness: " + fitness);

    }
}
