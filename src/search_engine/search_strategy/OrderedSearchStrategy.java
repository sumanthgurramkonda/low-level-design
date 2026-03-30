package search_engine.search_strategy;

import search_engine.Document;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class OrderedSearchStrategy implements SearchStrategy {


    @Override
    public List<Document> search(String query, Map<String, Set<Document>> documetMap) {
        return List.of();
    }
}
