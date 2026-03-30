package search_engine.search_strategy;

import search_engine.enums.SearchStrategy;

import static search_engine.enums.SearchStrategy.*;

public class SearchStrategyFactory {
    public static search_engine.search_strategy.SearchStrategy getSearchStrategy(SearchStrategy strategy) {
        return switch (strategy) {
            case UNORDERED_SEARCH -> new UnOrderedSearchStrategy();
            case ORDERED_SEARCH -> new OrderedSearchStrategy();
            default -> throw new IllegalArgumentException("Invalid search strategy: " + strategy);
        };
    }
}
