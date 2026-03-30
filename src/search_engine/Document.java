package search_engine;

import java.util.Date;

public class Document {

    private int id;
    private String content;
    private Date publishedDate;
    private Date lastUpdatedDate;
    private Date lastSearchedDate;
    private int searchFrequency;

    public Document(int id, String content) {
        this.id = id;
        this.content = content;
        this.publishedDate = new Date();
        this.lastUpdatedDate = new Date();
        this.lastSearchedDate = new Date();
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public Date getLastSearchedDate() {
        return lastSearchedDate;
    }

    public int getSearchFrequency() {
        return searchFrequency;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public void setLastSearchedDate(Date lastSearchedDate) {
        this.lastSearchedDate = lastSearchedDate;
    }

    public void incrementFrequency() {
        this.searchFrequency++;
    }
}
