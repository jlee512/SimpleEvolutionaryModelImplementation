import nz.ac.vuw.kol.OptimisationFunction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Julian on 9/01/2018.
 */
public class EvolutionaryComputationAssessment {


    public static void main(String[] args) {

        //Configuration variables
        int numParents = 2;

        // Initialisation Stage (i.e. preparing the initial population
        System.out.println("Generating values...");
        for (int i = 0; i < numParents; i++) {
            Chromosome chromosome = new Chromosome();
            chromosome.printValues();
        }

    }

    //Method used to combine a set of parents together and create two children
}
