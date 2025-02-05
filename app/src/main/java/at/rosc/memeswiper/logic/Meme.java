package at.rosc.memeswiper.logic;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meme meme = (Meme) o;
        return Objects.equals(url, meme.url);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(url);
    }
}
