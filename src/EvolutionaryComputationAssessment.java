import nz.ac.vuw.kol.OptimisationFunction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Julian on 9/01/2018.
 */
public class EvolutionaryComputationAssessment {


    public static void main(String[] args) {

        //Configuration variables
        int numParents = 20;

        // Initialisation Stage (i.e. preparing the initial population
        List<Double[]> parents = new ArrayList<>();
        for (int i = 0; i < 20; i++) {

            Double[] parent = randomiseSet();
            parents.add(parent);

        }

    }

    //Method used to randomise a set of double[] for use within the fitness function
    public static Double[] randomiseSet() {


        return null;
    }

    //Method used to combine a set of parents together and create two children
}
