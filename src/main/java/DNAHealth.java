public class DNAHealth {
    public int highestStrandScore;
    public int lowestStrandScore;

    public DNAHealth(int lowest, int highest){
        this.lowestStrandScore = lowest;
        this.highestStrandScore = highest;
    }

    @Override
    public String toString(){
        return lowestStrandScore+" "+highestStrandScore;
    }
}
