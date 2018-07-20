import org.ahocorasick.trie.Emit;
import org.ahocorasick.trie.Trie;

import java.util.Collection;

public class AhoCorasickRepo {
    public Collection<Emit> getEmits(String searchTerm, String[] keywords){
        Trie trie = Trie.builder()
                .addKeywords(keywords)
                .build();
        Collection<Emit> emits = trie.parseText(searchTerm);
        return emits;
    }
}
