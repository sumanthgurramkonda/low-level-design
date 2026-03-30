package search_engine;

import java.util.ArrayList;
import java.util.List;

public class Client {

    public static void main(String[] args) {
            SimpleSearchEngine searchEngine = new SimpleSearchEngine.Builder()
                    .setTokenizer(search_engine.enums.Tokenizer.SIMPLE_TOKENIZER)
                    .setSearchStrategy(search_engine.enums.SearchStrategy.UNORDERED_SEARCH)
                    .build();

            List<Document> documents = List.of(
                    new Document(1,"The quick brown fox jumps over the lazy dog"),
                    new Document(2,"The lazy dog is sleeping"),
                    new Document(3,"The fox is quick and clever")
            );
            searchEngine.addDocument(documents);

            String query = "clever";
            List<Document> result = searchEngine.search(query);

            System.out.println("Search results for query: " + query);
            for (Document doc : result) {
                System.out.println(doc.getContent());
            }
    }
}
