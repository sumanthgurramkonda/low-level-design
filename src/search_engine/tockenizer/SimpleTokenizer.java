package search_engine.tockenizer;

import java.util.List;

public class SimpleTokenizer implements Tokenizer {

    @Override
    public List<String> tokenize(String sentence) {
        // We can use regex to split the sentence into words. This is a very basic implementation and can be improved to handle special characters, stop words, etc.
        return List.of(sentence.split("\\s+"));
    }
}
