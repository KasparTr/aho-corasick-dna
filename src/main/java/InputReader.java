import java.util.Scanner;

public class InputReader {
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Read input as following lines:
     *  1) an integer denoting the total number of genes.
     *  2) space-separated strings describing the respective values of genes (genes)
     *  3) space-separated integers describing the corresponding values of gene health (health)
     *  4) integer denoting the number of strands of DNA to process.
     *  5+) Each of the subsequent lines describes a DNA strand in the form 'start', 'end', 'd'.
     *      Where 'start', ' end' (int) denote (inclusive) the healthy genes of line #2
     *      Where d (String) is the dna strand of genes to analyze
     * @return
     */
    public static DNA readDnaInputFromConsole(){
        System.out.println("Enter gene data");
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] genes = new String[n];

        String[] genesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String genesItem = genesItems[i];
            genes[i] = genesItem;
        }

        int[] health = new int[n];

        String[] healthItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int healthItem = Integer.parseInt(healthItems[i]);
            health[i] = healthItem;
        }

        int s = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        Strand[] strands = new Strand[s];
        for (int sItr = 0; sItr < s; sItr++) {
            String[] firstLastd = scanner.nextLine().split(" ");

            int first = Integer.parseInt(firstLastd[0]);

            int last = Integer.parseInt(firstLastd[1]);

            String d = firstLastd[2];
            strands[sItr]=new Strand(first, last, d);
        }
        scanner.close();
        DNA dna = new DNA(n, genes, health, s, strands);
        return dna;
    }
}
