package com.medium.danieldiasjava.app;

public class Palestrante {

    private String title;

    private String description;

    private String speaker;

    public Palestrante() { }

    public Palestrante(String title, String description, String speaker) {
        this.title = title;
        this.description = description;
        this.speaker = speaker;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    @Override
    public String toString() {
        return "name:" + title + ", description:" + description + ", speaker:" + speaker;
    }
}