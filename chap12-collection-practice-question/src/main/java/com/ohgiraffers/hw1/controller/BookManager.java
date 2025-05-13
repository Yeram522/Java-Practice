package com.ohgiraffers.hw1.controller;

import com.ohgiraffers.hw1.model.comparator.AscCategory;
import com.ohgiraffers.hw1.model.comparator.DescCategory;
import com.ohgiraffers.hw1.model.dto.BookDTO;

import java.util.ArrayList;

public class BookManager {
    final private ArrayList<BookDTO> bookList;

    public BookManager() {
        bookList = new ArrayList<BookDTO>(); // bookList 인스턴스 생성
    }

    public void addBook(BookDTO book){
        bookList.add(book);
    }

    public void deleteBook(int index){
        bookList.remove(index);
    }

    public int searchBook(String title){
        // 순회해서 index를 반환한다.
        for(int i = 0; i < bookList.size(); i++){
            if(title.equals(bookList.get(i).getTitle())){
                return i;
            }
        }

        return -1;
    }

    public void printBook(int index){
        System.out.println(bookList.get(index).toString());
    }

    public void displayAll(){
        if(bookList.isEmpty()){
            System.out.println("출력할 도서가 없습니다.");
            return;
        }

        System.out.println(bookList);
    }

    public ArrayList<BookDTO> sortedBookList(int select) {

        switch (select){
            case 1:
                bookList.sort(new AscCategory());
                break;
            case 2:
                bookList.sort(new DescCategory());
                break;
            default:
                System.out.println("번호를 잘못입력하였습니다.");

        }

        return bookList;
    }

    public void printBookList(ArrayList<BookDTO> br){

        for(BookDTO book : br){
            System.out.println(book.toString());
        }

    }
}
