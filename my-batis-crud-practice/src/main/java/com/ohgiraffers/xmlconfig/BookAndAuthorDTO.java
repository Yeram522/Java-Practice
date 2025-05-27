package com.ohgiraffers.xmlconfig;

public class BookAndAuthorDTO {
    private int bookCode;
    private String bookName;
    private AuthorDTO author;
    private int publishYear;
    private int bookPrice;
    private int isbn;
    private String etc; // Nullable

    public BookAndAuthorDTO(){}

    public BookAndAuthorDTO(int bookCode, String bookName, AuthorDTO author, int publishYear, int bookPrice, int isbn, String etc) {
        this.bookCode = bookCode;
        this.bookName = bookName;
        this.author = author;
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

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
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
        return "BookAndAuthorDTO{" +
                "bookCode=" + bookCode +
                ", bookName='" + bookName + '\'' +
                ", author=" + author +
                ", publishYear=" + publishYear +
                ", bookPrice=" + bookPrice +
                ", isbn=" + isbn +
                ", etc='" + etc + '\'' +
                '}';
    }
}
