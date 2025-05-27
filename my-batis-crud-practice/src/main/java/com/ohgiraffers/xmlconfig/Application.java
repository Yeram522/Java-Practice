package com.ohgiraffers.xmlconfig;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BookController bookController = new BookController();

        boolean trigger = true;
        do{
            System.out.println("===========도서 관리=============");
            System.out.println("1. 도서 전체 조회");
            System.out.println("2. 도서 코드로 도서 조회");
            System.out.println("3. 신규 도서 추가");
            System.out.println("4. 도서 수정");
            System.out.println("5. 도서 삭제");
            System.out.print("도서 관리 번호를 입력하세요 : ");
            int select = sc.nextInt();

            switch (select){
                case 1:
                    bookController.selectAllBook();
                    break;
                case 2:
                    bookController.selectBookByCode(inputMenuCode());
                    break;
                case 3:
                    bookController.registBook(inputBookinfo());
                    break;
                case 4:
                    bookController.modifyBook(inputModifyBook()); break;
                case 5:
                    bookController.deleteBook(inputDeleteBook()); break;
                case - 1:
                    trigger = false;
                    break;
            }
        }while (trigger);

    }




    static int inputMenuCode(){
        Scanner sc = new Scanner(System.in);

        System.out.print("조회할 메뉴 코드 입력 : ");
        return sc.nextInt();
    }

    static Map<String, String> inputBookinfo(){
        Scanner sc = new Scanner(System.in);

        System.out.println("추가할 도서의 제목을 입력해주세요. :");
        String name = sc.nextLine();
        System.out.println("추가할 도서의 작가 코드 입력해주세요. :");
        String authorCode = sc.nextLine();
        System.out.println("추가할 도서의 출판 년도 입력해주세요. :");
        String pubYear = sc.nextLine();
        System.out.println("추가할 도서의 가격을 입력해주세요. :");
        String price = sc.nextLine();
        System.out.println("ISBN :");
        String isbn = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("name", name);
        parameter.put("authorCode", authorCode);
        parameter.put("pubYear", pubYear);
        parameter.put("price", price);
        parameter.put("isbn", isbn);

        return parameter;
    }

    private static  Map<String, String> inputModifyBook() {
        Scanner sc = new Scanner(System.in);
        boolean trigger = true;

        System.out.print("수정할 도서의 코드를 입력해주세요. : ");
        String code = sc.nextLine();
        String price = null;
        String etc= null;

        do{
            System.out.println("--------<수정할 속성을 선택해주세요>--------");
            System.out.println("1. 도서 가격");
            System.out.println("2. 도서 비고");
            System.out.println("9. 수정 완료");

            String select = sc.nextLine();

            switch (Integer.parseInt(select)){
                case 1:
                    System.out.println("수정할 도서 가격을 입력해주세요.");
                    price = sc.nextLine();
                    break;
                case 2:
                    System.out.println("수정할 도서의 비고를 입력해주세요.");
                    etc = sc.nextLine();
                    break;
                case 9:
                    trigger = false;
                    break;
                default:
                    System.out.println("잘못입력하셨습니다.");
            }
        }while (trigger);



        Map<String, String> parameter = new HashMap<>();
        parameter.put("bookCode", code);
        parameter.put("etc", etc);
        parameter.put("bookPrice", price);

        return parameter;
    }

    private static Map<String, String> inputDeleteBook() {
        Scanner sc = new Scanner(System.in);
        System.out.println("삭제할 도서 코드를 입력하세요 : ");
        String code = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("code", code);

        return parameter;
    }


}
