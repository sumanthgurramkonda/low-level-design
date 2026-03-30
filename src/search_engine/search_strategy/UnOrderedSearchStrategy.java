package search_engine.search_strategy;

import search_engine.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UnOrderedSearchStrategy implements SearchStrategy {

    @Override
    public List<Document> search(String query, Map<String, Set<Document>> documetMap) {
        final String[] queryWords = query.split(" ");
        List<Document> document = new ArrayList<>();
        for(String word : queryWords) {
            if(documetMap.containsKey(word)) {
                document.addAll(documetMap.get(word));
            }
        }
        return document;
    }
}
