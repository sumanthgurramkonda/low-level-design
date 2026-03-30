package search_engine;

import search_engine.enums.Tokenizer;
import search_engine.search_strategy.SearchStrategy;
import search_engine.search_strategy.SearchStrategyFactory;
import search_engine.tockenizer.TokenizerFactory;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class SimpleSearchEngine {

    private InvertedIndex invertedIndex;
    private search_engine.tockenizer.Tokenizer tokenizer;
    private SearchStrategy searchStrategy;

    public SimpleSearchEngine() {
        this.tokenizer = TokenizerFactory.getTokenizer(Tokenizer.SIMPLE_TOKENIZER);
        this.invertedIndex = new InvertedIndex(tokenizer);
        this.searchStrategy = SearchStrategyFactory.getSearchStrategy(search_engine.enums.SearchStrategy.UNORDERED_SEARCH);
    }

    public SimpleSearchEngine(Tokenizer tokenizer) {
        this.invertedIndex = new InvertedIndex(TokenizerFactory.getTokenizer(tokenizer));;
    }

    public void addDocument(List<Document> docs) {
        invertedIndex.addDocument(docs);
    }

    public List<Document> search(String query) {
        return searchStrategy.search(query, invertedIndex.getDocumetMap());
    }



    public static class Builder{
        private Tokenizer tokenizer;
        private SearchStrategy searchStrategy;

        public Builder setTokenizer(Tokenizer tokenizer) {
            this.tokenizer = tokenizer;
            return this;
        }

        public Builder setSearchStrategy(SearchStrategy searchStrategy) {
            this.searchStrategy = searchStrategy;
            return this;
        }

        public SimpleSearchEngine build() {
            SimpleSearchEngine searchEngine = new SimpleSearchEngine(tokenizer);
            searchEngine.searchStrategy = this.searchStrategy;
            return searchEngine;
        }

        public Builder setSearchStrategy(search_engine.enums.SearchStrategy searchStrategy) {
            this.searchStrategy = SearchStrategyFactory.getSearchStrategy(searchStrategy);
            return this;
        }
    }

}
