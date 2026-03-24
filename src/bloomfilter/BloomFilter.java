package bloomfilter;

import bloomfilter.strategy.interfaces.HashStrategy;

import java.util.BitSet;

public class BloomFilter {

    private HashStrategy hashStrategy;
    private BitArray bitArray;
    private BloomFilterConfig config;

    public BloomFilter() {

    }

    public BloomFilter(BloomFilterConfig config, HashStrategy hashStrategy) {
        this.config = config;
        this.hashStrategy = hashStrategy;
        this.bitArray = new BitArray(config.getBitArraySize());
    }

    synchronized public void add(String element) {
        for (int i = 0; i < config.getHashFunctionsCount(); i++) {
            int hash = hashStrategy.hash(element, i, config.getBitArraySize());
            bitArray.set(hash);
        }
    }

    synchronized public  boolean contains(String element) {
        if (element == null) {
            throw new IllegalArgumentException("Element cannot be null");
        }
        for (int i = 0; i < config.getHashFunctionsCount(); i++) {
            int hash = hashStrategy.hash(element, i, config.getBitArraySize());
            if (!bitArray.get(hash)) {
                return false;
            }
        }
        return true;
    }

    synchronized public void clear() {
        bitArray.clear();
    }

    public BloomFilterConfig getConfig() {
        return config;
    }

    public static class Builder {
        private int expectedElements;
        private int falsePositiveRate;
        private HashStrategy hashStrategy;

        public Builder setExpectedElements(int expectedElements) {
            this.expectedElements = expectedElements;
            return this;
        }

        public Builder setFalsePositiveRate(int falsePositiveRate) {
            this.falsePositiveRate = falsePositiveRate;
            return this;
        }

        public Builder setHashStrategy(HashStrategy hashStrategy) {
            this.hashStrategy = hashStrategy;
            return this;
        }

        public BloomFilter build() {
            BloomFilterConfig config = new BloomFilterConfig(expectedElements, falsePositiveRate);
            return new BloomFilter(config, hashStrategy);
        }
    }

}
