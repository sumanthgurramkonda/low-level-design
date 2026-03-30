package search_engine;

import search_engine.tockenizer.SimpleTokenizer;
import search_engine.tockenizer.Tokenizer;

import java.util.*;

public class InvertedIndex {

    private Map<String, Set<Document>> documetMap = new HashMap<>();
    private Tokenizer tokenizer;

    public InvertedIndex() {
        this.tokenizer = new SimpleTokenizer();
    }

    public InvertedIndex(Tokenizer tokenizer) {
        this.tokenizer = tokenizer;
    }

    public void addDocument(Document doc) {
        List<String> tokens = tokenizer.tokenize(doc.getContent());

        for(String word : tokens) {
            documetMap.putIfAbsent(word, new HashSet<>());
            documetMap.get(word).add(doc);
        }
    }

    public void addDocument(List<Document> doc) {
        for(Document document : doc) {
            addDocument(document);
        }
    }

    public  Map<String, Set<Document>> getDocumetMap() {
        return documetMap;
    }

}
