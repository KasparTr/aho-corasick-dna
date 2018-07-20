import org.ahocorasick.trie.Emit;

import java.util.*;

public class HealthAnalyzer {
    AhoCorasickRepo ahoCorasickRepo = new AhoCorasickRepo();

    public DNAHealth getDnaHealth(DNA dna){
        Map<String, List<Integer>> healthyGeneHealthMap;
        int highestStrandScore = 0;
        int lowestStrandScore = 9999999;

        for(Strand strand : dna.strands){
            int strandScore = 0;
            healthyGeneHealthMap = createHealthyGeneHealthMap(strand, dna);
            String searchTerm = strand.geneStrand;
            String[] keywords = healthyGeneHealthMap.keySet().toArray(new String[healthyGeneHealthMap.keySet().size()]);

            Collection<Emit> emits = ahoCorasickRepo.getEmits(searchTerm, keywords);
            //System.out.println(emits);

            for(Emit e:emits){
                strandScore += sum(healthyGeneHealthMap.get(e.getKeyword()));
            }

            if(strandScore > highestStrandScore) highestStrandScore = strandScore;
            if(strandScore < lowestStrandScore) lowestStrandScore = strandScore;
        }
        return new DNAHealth(lowestStrandScore, highestStrandScore);
    }

    private Map<String, List<Integer>> createHealthyGeneHealthMap(Strand strand, DNA dna){
        Map<String, List<Integer>> healthyMap = new HashMap();
        for(int i=0;i < dna.genes.length; i++){
            if(i >= strand.healthyGeneStartIndex && i<=strand.healthyGeneEndIndex ){
                List<Integer> l;
                if(healthyMap.get(dna.genes[i]) != null){
                    healthyMap.get(dna.genes[i]).add(dna.health[i]);
                }else{
                    l = new ArrayList();
                    l.add(dna.health[i]);
                    healthyMap.put(dna.genes[i], l);
                }
            }
        }
        return healthyMap;
    }

    public static int sum(List<Integer> list) {
        int sum = 0;
        for (int i: list) {
            sum += i;
        }
        return sum;
    }
}
