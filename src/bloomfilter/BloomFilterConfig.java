package bloomfilter;

public class BloomFilterConfig {
    private int expectedElements;
    private int falsePositiveRate;
    private int bitArraySize;
    private int hashFunctionsCount;

    public BloomFilterConfig(int expectedElements, int falsePositiveRate) {
        this.expectedElements = expectedElements;
        this.falsePositiveRate = falsePositiveRate;
        this.bitArraySize = Math.abs(calculateBitArraySize(expectedElements, falsePositiveRate));
        this.hashFunctionsCount = Math.abs(calculateHashFunctionsCount(bitArraySize, expectedElements));
    }
    private int calculateBitArraySize(int expectedElements, int falsePositiveRate) {
        return (int) Math.ceil(-expectedElements * Math.log(falsePositiveRate) / (Math.log(2) * Math.log(2)));
    }
    private int calculateHashFunctionsCount(int bitArraySize, int expectedElements) {
        return (int) Math.round((bitArraySize / expectedElements) * Math.log(2));
    } 
    public int getExpectedElements() {
        return expectedElements;
    }

    public int getHashFunctionsCount() {
        return hashFunctionsCount;
    }

    public int getFalsePositiveRate() {
        return falsePositiveRate;
    }
    public int getBitArraySize() {
        return bitArraySize;
    }


}
