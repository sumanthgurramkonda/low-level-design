package urlshortner;

public class URLMapping {

    private String originalURL;
    private String shortURL;
    private long createdAt;

    public URLMapping(String originalURL, String shortURL) {
        this.originalURL = originalURL;
        this.shortURL = shortURL;
        this.createdAt = System.currentTimeMillis();
    }

    public String getOriginalURL() {return this.originalURL;}

    public  String getShortURL() {return this.shortURL;}

    public long getCreatedAt() {return this.createdAt;}


}
