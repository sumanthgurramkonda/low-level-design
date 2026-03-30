package url_shortener;

import java.util.HashMap;
import java.util.Map;

public class URLDB {

    private Map<String, URLMapping> urlDB = new HashMap<>();

    public void saveURLMapping(URLMapping urlMapping){

        urlDB.put(urlMapping.getShortURL(), urlMapping);

    }

    public URLMapping getURLMapping(String shortURL){
        return urlDB.get(shortURL);
    }

    public boolean deleteURLMapping(String shortURL){
        if(!urlDB.containsKey(shortURL)){
            return false;
        }
        urlDB.remove(shortURL);
        return true;
    }
}
