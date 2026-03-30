package search_engine.tockenizer;

public class TokenizerFactory {

    public static Tokenizer getTokenizer(search_engine.enums.Tokenizer tokenizerType) {
        switch (tokenizerType) {
            case SIMPLE_TOKENIZER:
                return new SimpleTokenizer();
            default:
                throw new IllegalArgumentException("Invalid tokenizer type: " + tokenizerType);
        }
    }
}
