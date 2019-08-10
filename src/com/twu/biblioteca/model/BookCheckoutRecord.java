package com.twu.biblioteca.model;

public class BookCheckoutRecord {
    private String bookTitle;
    private String userId;

    public BookCheckoutRecord(String bookTitle, String userId) {
        this.bookTitle = bookTitle;
        this.userId = userId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
