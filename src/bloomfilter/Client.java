package bloomfilter;

import bloomfilter.strategy.FNVHashStrategy;

public class Client {

    public static void main(String[] args) {

        BloomFilter bloomFilter = new BloomFilter.Builder()
                .setExpectedElements(10000)
                .setFalsePositiveRate(5)
                .setHashStrategy(new FNVHashStrategy())
                .build();
        for(int i=0;i<10000;i++){
            bloomFilter.add("Suagvdssb1"+i);
        }
        System.out.println(bloomFilter.contains("Suagvsb1"));
    }
}
