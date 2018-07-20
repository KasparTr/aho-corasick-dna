public class DNA {
    public int n;
    public String[] genes;
    public int[] health;
    public int nrOfStrands;
    public Strand[] strands;

    public DNA(int n, String[] genes, int[] health, int nrOfStrands, Strand[] strands){
        this.n = n;
        this.genes = genes;
        this.health = health;
        this.nrOfStrands = nrOfStrands;
        this.strands = strands;
    }
}
