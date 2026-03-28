package auto_search_complete;

import auto_search_complete.ranking_strategy.RankingStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AutoSearchCompleteSystem {

    private final Trie trie;
    private RankingStrategy rankingStrategy;
    private int rankingLimit;

    public AutoSearchCompleteSystem(RankingStrategy rankingStrategy, int rankingLimit) {
        this.trie = new Trie();
        this.rankingStrategy = rankingStrategy;
        this.rankingLimit = rankingLimit;
    }

    public List<String> findMatchings(String word) {
        Map<String, Integer> matchingsFreq = trie.findMatchings(word.toLowerCase());
        return rankingStrategy.rank(matchingsFreq,rankingLimit);
    }

    public void insert(String word) {
        trie.insert(word.toLowerCase());
    }

    public List<String> search(String word) {
        return null;
    }

    public void setRankingStrategy(RankingStrategy rankingStrategy) {
        this.rankingStrategy = rankingStrategy;
    }

    public void setRankingLimit(int rankingLimit) {
        this.rankingLimit = rankingLimit;
    }
}
