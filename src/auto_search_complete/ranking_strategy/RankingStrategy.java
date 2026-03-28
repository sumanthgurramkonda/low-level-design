package auto_search_complete.ranking_strategy;

import java.util.List;
import java.util.Map;

public interface RankingStrategy {
    List<String> rank(Map<String, Integer> sentenceRank, int limit);
}
