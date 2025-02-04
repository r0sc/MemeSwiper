package at.rosc.memeswiper.logic;

public class Meme {
    private String url;
    private String title;

    public Meme(String url, String title) {
        this.url = url;
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }
}
