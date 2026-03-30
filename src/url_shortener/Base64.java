package url_shortener;

public class Base64 {

    private static final String BASE62_CHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final int BASE = BASE62_CHARS.length();
    private Base64(){}

    public static String encode(long num){
        num = Math.abs(num);
        StringBuilder shortUrl = new StringBuilder();
        if (num == 0) {
            return String.valueOf(BASE62_CHARS.charAt(0));
        }
        while(num>0){
            int rem = (int)(num % BASE);
            shortUrl.append(BASE62_CHARS.charAt(rem));
            num /= BASE;
        }
        return shortUrl.reverse().toString();
    }

}
