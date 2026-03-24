package bloomfilter.strategy.interfaces;

public interface HashStrategy {

    int hash(String value, int seed, int bitArraySize);
}
