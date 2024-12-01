package com.ex;

import java.util.Objects;

public class WiseSaying {
    Long id;
    String content;
    String author;

    public WiseSaying(Long id, String content, String author) {
        this.id = id;
        this.author = author;
        this.content = content;
    }

    public WiseSaying(String content, String author) {
        this.content = content;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString(){
        return String.format("%d / %s / %s", id, author, content);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WiseSaying that = (WiseSaying) o;
        return Objects.equals(id, that.id) && Objects.equals(content, that.content) && Objects.equals(author, that.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, author);
    }
}
