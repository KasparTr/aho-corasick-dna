public class Analyzer {
    /**
     * This program analyzes the health of a gene, solving the problem stated in HackerRank
     *  https://www.hackerrank.com/challenges/determining-dna-health/problem
     * For string matching, I am using the Aho-Corasick algorithm implementation stated here:
     *  https://github.com/robert-bor/aho-corasick
     * This program is solely for study puropses only.
     * @param args
     */
    public static void main(String[] args) {
        DNA dna = InputReader.readDnaInputFromConsole();

        // Determine DNA health
        HealthAnalyzer ha = new HealthAnalyzer();
        DNAHealth dnaHealth = ha.getDnaHealth(dna);

        System.out.println(dnaHealth.toString());

    }
}
