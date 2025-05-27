package com.ohgiraffers.xmlconfig;

import java.util.List;
import java.util.Map;

public class BookController {

    private final PrintResult printResult;

    private final BookService bookService;

    public BookController(){
        printResult = new PrintResult();
        bookService = new BookService();
    }

    public void selectAllBook(){

        List<BookAndAuthorDTO> menuList = bookService.selectAllBook();

        if(menuList != null){
            printResult.printBookList(menuList);
        }else {
            printResult.printErrorMessage("selectList");
        }
    }


    public void selectBookByCode(int code) {

        BookDTO bookDTO = bookService.selectBookByCode(code);

        if(bookDTO != null){
            printResult.printBook(bookDTO);
        }else{
            printResult.printErrorMessage("selectOne");
        }
    }


    public void registBook(Map<String, String> parameter) {

        String name = parameter.get("name");
        int price = Integer.parseInt(parameter.get("price"));
        int year = Integer.parseInt(parameter.get("pubYear"));
        int isbn = Integer.parseInt(parameter.get("isbn"));
        int authorCode = Integer.parseInt(parameter.get("authorCode"));

        BookDTO book = new BookDTO();
        book.setBookName(name);
        book.setAuthorName(authorCode);
        book.setBookPrice(price);
        book.setPublishYear(year);
        book.setIsbn(isbn);

        if(bookService.registBook(book)){
            printResult.printSuccessMessage("insert");
        }else{
            printResult.printErrorMessage("insert");
        }
    }

    public void modifyBook(Map<String, String> parameter) {
        String etc = parameter.get("etc");
        int price = Integer.parseInt(parameter.get("bookPrice"));
        int code = Integer.parseInt(parameter.get("bookCode"));


        BookDTO book = new BookDTO();
        book.setBookCode(code);
        book.setBookName(etc);
        book.setBookPrice(price);

        if(bookService.modifyBook(book)){
            printResult.printSuccessMessage("insert");
        }else{
            printResult.printErrorMessage("insert");
        }
    }

    public void deleteBook(Map<String, String> parmeter) {
        int code = Integer.parseInt(parmeter.get("code"));

        if(bookService.deleteBookByCode(code)){
            printResult.printSuccessMessage("delete");
        }else{
            printResult.printErrorMessage("delete");
        }


    }
}
