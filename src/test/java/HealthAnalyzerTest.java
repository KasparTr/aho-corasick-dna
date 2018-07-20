import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HealthAnalyzerTest {

    private Strand[] createTestStrands(){
        return new Strand[]{
                new Strand(1,5,"caaab"),
                new Strand(0,4,"xyz"),
                new Strand(2,4,"bcdybc")
        };
    }

    @Test
    public void testIfGetDnaHealthReturnsCorrectResult(){
        System.out.println("Test | testIfGetDnaHealthReturnsCorrectResult");
        HealthAnalyzer ha = new HealthAnalyzer();
        Strand[] testStrands = createTestStrands();
        DNAHealth dnaHealth = ha.getDnaHealth(new DNA(6, new String[]{"a","b","c","aa","d","b"}, new int[]{1,2,3,4,5,6}, 3, testStrands));
        assertTrue(dnaHealth.lowestStrandScore==0);
        assertTrue(dnaHealth.highestStrandScore==19);

    }

}
