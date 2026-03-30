package url_shortener;

public class URLShortenerService {


    private URLDB urlDB;
    private String baseURL= "http://short.url/";

    public URLShortenerService() {
        this.urlDB = new URLDB();
    }

    public String createShortURL(String originalURL) {
        String shortURL = baseURL + Base64.encode(originalURL.hashCode());
        URLMapping urlMapping = new URLMapping(originalURL, shortURL);
        urlDB.saveURLMapping(urlMapping);
        return shortURL;
    }

    public String getOriginalURL(String shortURL) {
        URLMapping urlMapping = urlDB.getURLMapping(shortURL);
        if (urlMapping != null) {
            return urlMapping.getOriginalURL();
        }
        return null;
    }

    public boolean deleteShortURL(String shortURL) {
        return urlDB.deleteURLMapping(shortURL);
    }

}
