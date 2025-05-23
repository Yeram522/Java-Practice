package com.ohgiraffers.run;

import java.util.Scanner;

import static com.ohgiraffers.run.Commander.selectCommand;
import static com.ohgiraffers.run.Commander.showMenu;

public class Application {


    public static void main(String[] args) {
        int select = 0;
        Scanner sc = new Scanner(System.in);

        do{
            showMenu();

            select = sc.nextInt();
            if(select <= 0)
                break;
            selectCommand(select);

        }
        while(true);

        System.out.println("프로그램이 종료 되었습니다.");
    }


}
