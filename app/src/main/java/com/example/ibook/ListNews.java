package com.example.ibook;

public class ListNews {
    String title_news,short_description_news,date_news,author_name_news,full_description_news;
    int image_news;

    public ListNews(String title_news, String short_description_news, String date_news, String author_name_news, String full_description_news, int image_news) {
        this.title_news = title_news;
        this.short_description_news = short_description_news;
        this.date_news = date_news;
        this.author_name_news = author_name_news;
        this.full_description_news = full_description_news;
        this.image_news=image_news;
    }
}
