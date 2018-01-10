import nz.ac.vuw.kol.OptimisationFunction;

import java.util.*;

/**
 * Created by Julian on 9/01/2018.
 */
public class Chromosome {

    private List<Integer> parentIndices = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4));

    private double[] values;
    private double fitness;

    //Method to randomise Chromosome
    public Chromosome(double max, double min) {
        randomiseValues(max, min);
        calculateFitness();
    }

    //Method to create new chromosome using recombination
    public Chromosome(Chromosome parent1, Chromosome parent2, double max, double min) {

        values = new double[5];

        //Generate random indices to select from each parent
        //Generate parent 1 indices (non-duplicate)
        for (int i = 0; i < 3; i++) {
            int selectedIndex = (int) (Math.random() * parentIndices.size());
            int p1Index = parentIndices.get(selectedIndex);
            values[i] = parent1.getValues()[p1Index];
            parentIndices.remove(selectedIndex);
        }
        //Generate parent 2 indices (non-duplicate)
        resetParentIndicesList();
        for (int i = 3; i < 5; i++) {
            int selectedIndex = (int) (Math.random() * parentIndices.size());
            int p2Index = parentIndices.get(selectedIndex);
            values[i] = parent1.getValues()[p2Index];
            parentIndices.remove(selectedIndex);
        }

        //Mutation to be added at a later stage
        //Randomise number of genes to mutate and the specific index to mutate as well as the direction of mutation
        int numberToMutate = (int) (Math.random() * 6);
//        System.out.println("Mutating " + numberToMutate + " genes");
        resetParentIndicesList();
        for (int i = 0; i < numberToMutate; i++) {
            int selectedIndex = (int) (Math.random() * parentIndices.size());
            int mutateIndex = parentIndices.get(selectedIndex);
//            System.out.println("Index: " + mutateIndex);
            //Mutate by value within +/-(max - min)/40
            values[mutateIndex] = values[mutateIndex] + (Math.random() - (max - min) / 40);
//            System.out.println("Gene mutated");
            parentIndices.remove(selectedIndex);
        }


        //Calculate chromosome fitness
        calculateFitness();
    }

    public void resetParentIndicesList() {
        parentIndices = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4));
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

    public static void main(String[] args) {
        //Local testing
//        double[] test = new double[5];
//        test[0] = -0.5834823837909138;
//        test[1] = -0.5834823837909138;
//        test[2] = -0.5834823837909138;
//        test[3] = -0.5834823837909138;
//        test[4] = -0.5834823837909138;
//        System.out.println(OptimisationFunction.unknownFunction(test));
    }
}
