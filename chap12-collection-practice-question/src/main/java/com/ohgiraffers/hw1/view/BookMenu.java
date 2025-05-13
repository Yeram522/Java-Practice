package com.ohgiraffers.hw1.view;

import com.ohgiraffers.hw1.controller.BookManager;
import com.ohgiraffers.hw1.model.dto.BookDTO;

import java.util.Scanner;

public class BookMenu {
    private Scanner sc = new Scanner(System.in);
    private final BookManager bookManager = new BookManager();

    public BookMenu() {}
    
    public void menu(){
        int bookId = 0;
        // 메인 메뉴 출력, 각 메뉴에 해당하는 BookManager 클래스의 메소드 실행 -> 반복 출력
        while (true){
            System.out.println("*** 도서 관리 프로그램 ***");
            System.out.println("1. 새 도서 추가");
            System.out.println("2. 도서정보 정렬 후 출력");
            System.out.println("3. 도서 삭제");
            System.out.println("4. 도서 검색 출력");
            System.out.println("5. 전체 출력");
            System.out.println("6. 끝내기");

            System.out.print("메뉴 번호 선택 : ");
            int select = sc.nextInt();
            sc.nextLine();

            switch (select){
                case 1:
                    bookManager.addBook(inputBook());
                    break;
                case 2:
                    System.out.print("정렬 방식을 선택해주세요(1. 오름차순, 2.내림차순)");
                    int nsorted = sc.nextInt();
                    sc.nextLine(); // 버퍼 비움

                    bookManager.printBookList(bookManager.sortedBookList(nsorted));
                    break;
                case 3:
                    bookId =  bookManager.searchBook(inputBookTitle());
                    if(bookId == -1){
                        System.out.println("삭제할 글이 존재하지 않음");
                        break;
                    }
                    bookManager.deleteBook(bookId);
                    break;
                case 4:
                    bookId = bookManager.searchBook(inputBookTitle());
                    if(bookId == -1){
                        System.out.println("조회한 도서가 존재하지 않음");
                    }else{
                        bookManager.printBook(bookId);
                    }
                    break;
                case 5:
                    bookManager.displayAll();
                    break;
                case 6:
                    // main()으로 리턴
                    return;
                default:
                    System.out.println("잘못된 번호 입니다.");
                    break;
            }
        }
        
    }

    // BookDTP 객체의 필드 값을 키보드로 입력 받아 초기화 하고 객체 리턴
    public BookDTO inputBook(){
        // 입력 받기
        System.out.print("도서 번호 : ");
        int bnum = sc.nextInt();
        sc.nextLine(); // 버퍼 비움


        System.out.print("도서 제목 : ");
        String btitle = sc.nextLine();

        System.out.print("도서 장르 ( 1:인문 /2:자연과학 /3.의료 /4.기타):");
        int bcategory = sc.nextInt();
        sc.nextLine();// 버퍼 비움

        System.out.print("도서 저자 : ");
        String bauthor = sc.nextLine();

        // 인스턴스 생성 및 반환
        return new BookDTO(bnum, bcategory, btitle, bauthor);
    }

    // 검색할 도서 제목을 키보드로 입력 받아 리턴
    public String inputBookTitle(){
        return sc.nextLine();
    }
}
