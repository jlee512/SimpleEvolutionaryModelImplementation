/**
 * Created by Julian on 8/01/2018.
 */
public class SimpleEvolutionExample {

    static float evaluationFunction(float x) {

        float functionReturn = 0;

        for (int i = 1; i < 6; i++) {
            functionReturn += (i * Math.cos((i + 1) * x + i));
//            System.out.println("Increment result: " + (i * Math.cos((i + 1) * x + i)));
        }

        System.out.println("Function result: " + functionReturn);
        return functionReturn;
    }

    public static void main(String[] args) {

        getFunctionMaxFullSearch();

        getFunctionMaxEvolutionarySearch();

    }

    public static void getFunctionMaxEvolutionarySearch() {

        float parent = (float) (-10 + Math.random() * 20);

        long time = System.currentTimeMillis();

        while (System.currentTimeMillis() - time < 30000) {

            float child = (float) (-10 + Math.random() * 20);
            System.out.println("Child: " + child);

            if (evaluationFunction(child) > evaluationFunction(parent)) {
                parent = child;
            }

            System.out.println("Parent evo: " + parent);

        }

        System.out.println("Result evo: " + parent);

    }

    public static void getFunctionMaxFullSearch() {
        float parent = (float) - 10;
        float increment = (float) - 10;
        float maxParent = 10;

        while (increment <= maxParent) {

            float child = increment + 0.1f;
            System.out.println("Child: " + child);

            if (evaluationFunction(child) > evaluationFunction(parent)) {
                parent = child;
            }

            System.out.println("Parent: " + parent);

            increment = child;

        }

        System.out.println("Result: " + parent);
    }

}
