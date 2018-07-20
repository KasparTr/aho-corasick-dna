public class Strand {
    public int healthyGeneStartIndex;
    public int healthyGeneEndIndex;
    public String geneStrand;

    public Strand(int startIdx, int endIdx, String geneStrand){
        this.healthyGeneStartIndex = startIdx;
        this.healthyGeneEndIndex = endIdx;
        this.geneStrand = geneStrand;
    }
}
