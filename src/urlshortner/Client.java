package urlshortner;

public class Client {

    public static void main(String[] args) {

        URLShortenerService urlShortenerService = new URLShortenerService();

        String originalURL = "https://sumanth-gurramkonda-portfolio.netlify.app/";
        String shortURL = urlShortenerService.createShortURL(originalURL);
        System.out.println("Short URL: " + shortURL);

        String retrievedOriginalURL = urlShortenerService.getOriginalURL(shortURL);
        System.out.println("Retrieved Original URL: " + retrievedOriginalURL);

        boolean isDeleted = urlShortenerService.deleteShortURL(shortURL);
        System.out.println("Short URL deleted: " + isDeleted);

         String afterDeletionOriginalURL = urlShortenerService.getOriginalURL(shortURL);
         System.out.println("After deletion, Retrieved Original URL: " + afterDeletionOriginalURL);
    }
}


