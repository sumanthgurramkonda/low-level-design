package auto_search_complete.ranking_strategy;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AlphabeticalRankingStrategy implements RankingStrategy {

    @Override
    public List<String> rank(Map<String, Integer> sentenceRank, int limit) {
        return sentenceRank.keySet().stream()
                .sorted()
                .limit(limit)
                .collect(Collectors.toList());
    }
}
