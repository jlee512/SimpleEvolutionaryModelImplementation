import java.util.Comparator;

/**
 * Created by Julian on 10/01/2018.
 */
public class FitnessComparator implements Comparator<Chromosome> {

    // Custom comparator class which compares chromosomes based on their calculated fitness
    @Override
    public int compare(Chromosome chromosome1, Chromosome chromosome2) {

        if (chromosome1.getFitness() > chromosome2.getFitness()) {
            return 1;
        } else if (chromosome1.getFitness() < chromosome2.getFitness()) {
            return -1;
        } else {
            return 0;
        }
    }
}
