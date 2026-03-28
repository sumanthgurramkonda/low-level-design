package auto_search_complete;

import auto_search_complete.ranking_strategy.FrequencyRankingStrategy;
import auto_search_complete.ranking_strategy.RankingStrategy;

public class Client {
    public static void main(String[] args) {
        RankingStrategy rankingStrategy = new FrequencyRankingStrategy();
        final int rankingLimit = 5;
        AutoSearchCompleteSystem searchCompleteSystem =  new AutoSearchCompleteSystem(rankingStrategy,rankingLimit);
        searchCompleteSystem.insert("Sumanth");
        searchCompleteSystem.insert("SumanthGurramkonda");
        searchCompleteSystem.insert("Gurramkonda");
        for(String word : searchCompleteSystem.findMatchings("Su")){
            System.out.println(word);
        }
    }
}
