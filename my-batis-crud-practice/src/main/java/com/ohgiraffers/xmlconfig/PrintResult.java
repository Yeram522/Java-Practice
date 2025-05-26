package com.ohgiraffers.xmlconfig;

import java.util.List;

public class PrintResult {

    public void printBookList(List<BookDTO> menuList){

        for(BookDTO menu : menuList){
            System.out.println(menu);
        }

    }

    public void printBook(BookDTO menu) {

        System.out.println(menu);
    }


    public void printSuccessMessage(String errorCode) {

        String successMessage = "";
        switch (errorCode){
            case "insert" :  successMessage = "신규 메뉴 등록을 성공하였습니다."; break;
            case "update" :  successMessage = "메뉴 수정을 성공하였습니다."; break;
            case "delete" :  successMessage = "메뉴 삭제를 성공하였습니다."; break;
        }

        System.out.println(successMessage);
    }


    public void printErrorMessage(String errorCode){
        String errorMessage = "";
        switch (errorCode){
            case "selectList": errorMessage = "도서 목록 조회를 실패하였습니다."; break;
            case "selectOne" : errorMessage = "도서 상세 조회를 실패하였습니다."; break;
            case "insert" : errorMessage = "신규 도서 등록을 실패하였습니다."; break;
            case "update" : errorMessage = "도서 정보 수정을 실패하였습니다."; break;
            case "delete" : errorMessage = "도서 정보 삭제를 실패하였습니다."; break;
        }

        System.out.println(errorMessage);
    }
}
