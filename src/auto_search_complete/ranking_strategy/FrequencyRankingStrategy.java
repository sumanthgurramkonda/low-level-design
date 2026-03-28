package auto_search_complete.ranking_strategy;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FrequencyRankingStrategy implements RankingStrategy {

    @Override
    public List<String> rank(Map<String, Integer> sentenceRank, int limit) {
        return sentenceRank.entrySet().stream()
                .sorted((a,b)->
                        b.getValue().equals(a.getValue()) ?
                                a.getKey().compareTo(b.getKey()) : Integer.compare(b.getValue(),a.getValue()))
                .limit(limit)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
