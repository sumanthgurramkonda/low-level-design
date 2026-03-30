package search_engine.tockenizer;

import java.util.List;

public interface Tokenizer {
    List<String> tokenize(String sentence);
}
