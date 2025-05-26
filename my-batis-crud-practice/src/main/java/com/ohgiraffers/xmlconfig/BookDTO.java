package com.ohgiraffers.xmlconfig;

public class BookDTO {
    private int bookCode;
    private String bookName;
    private int authorCode;
    private int publishYear;
    private int bookPrice;
    private int isbn;
    private String etc; // Nullable

    public BookDTO(){}

    public BookDTO(int bookCode, String bookName, int authorCode, int publishYear, int bookPrice, int isbn, String etc) {
        this.bookCode = bookCode;
        this.bookName = bookName;
        this.authorCode = authorCode;
        this.publishYear = publishYear;
        this.bookPrice = bookPrice;
        this.isbn = isbn;
        this.etc = etc;
    }

    public int getBookCode() {
        return bookCode;
    }

    public void setBookCode(int bookCode) {
        this.bookCode = bookCode;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getAuthorCode() {
        return authorCode;
    }

    public void setAuthorName(int authorCode) {
        this.authorCode = authorCode;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public int getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(int bookPrice) {
        this.bookPrice = bookPrice;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getEtc() {
        return etc;
    }

    public void setEtc(String etc) {
        this.etc = etc;
    }


    @Override
    public String toString() {
        return "BookDTO{" +
                "bookCode=" + bookCode +
                ", bookName='" + bookName + '\'' +
                ", authorCode=" + authorCode +
                ", publishYear=" + publishYear +
                ", bookPrice=" + bookPrice +
                ", idbn=" + isbn +
                ", etc='" + etc + '\'' +
                '}';
    }
}
