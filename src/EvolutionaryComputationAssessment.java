import nz.ac.vuw.kol.OptimisationFunction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Julian on 9/01/2018.
 */
public class EvolutionaryComputationAssessment {


    public static void main(String[] args) {

        //Configuration variables
        int numParents = 10;
        int minGenerations = 10;
        int maxGenerations = 100;
        //Setup search space
        double search_max = 10.0;
        double search_min = -10.0;
        //Setup variable to store minimum chromosome
        Chromosome minimum = new Chromosome(search_max, search_min);

        // 1. Initialisation phase: Generate the initial chromosome objects, and,
        // 2. Automatically evaluate fitness on creation
        ArrayList<Chromosome> chromosomes = generateChromosomes(numParents, search_max, search_min);

        // GENERATIONAL LOOP:
        System.out.println("Looping over minimum of " + minGenerations + " generations");
        int generation = 0;

        while (generation < minGenerations || generation < maxGenerations) {
            // Sort ArrayList of chromosomes
            Collections.sort(chromosomes,new FitnessComparator());
            //Update minimum based on the chromosome with the smallest fitness function value
            minimum = chromosomes.get(0);

            generation++;

        }

        System.out.println("---- Minimum ----");
        minimum.printValues();
        minimum.printFitness();
    }

    public static ArrayList<Chromosome> generateChromosomes(int numParents, double search_max, double search_min) {
        // Initialisation Stage (i.e. preparing the initial population
        System.out.println("Generating [" + numParents + "] random parents between:");
        System.out.println("[" + search_min + "] and, [" + search_max + "]");

        //Initialise ArrayList of chromosomes
        ArrayList<Chromosome> chromosomes = new ArrayList<>();

        for (int i = 0; i < numParents; i++) {
            Chromosome chromosome = new Chromosome(search_max, search_min);
            chromosome.printValues();
            chromosome.printFitness();
            System.out.println();
            chromosomes.add(chromosome);
        }

        return chromosomes;
    }

    //Method used to combine a set of parents together and create two children
}
