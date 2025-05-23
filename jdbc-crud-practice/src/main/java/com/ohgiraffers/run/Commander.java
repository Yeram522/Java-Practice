package com.ohgiraffers.run;

import com.ohgiraffers.model.dao.EmployeeDAO;
import com.ohgiraffers.model.dto.EmployeeDTO;

import java.util.Map;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Commander {
    private static final EmployeeDAO employeeDAO = new EmployeeDAO();
    private static final Scanner sc = new Scanner(System.in);

    static public void showMenu(){
        System.out.println("-----------------------------------------");

        System.out.println("CRUD 작업 목록(프로그램종료 : -1)");
        System.out.println("1. 전체 직원 조회");
        System.out.println("2. 직원 상세 조회");
        System.out.println("3. 직원 등록");
        System.out.println("4. 직원 수정");
        System.out.println("5. 직원 삭제");

        System.out.println("-----------------------------------------");
    }

    static public void selectCommand(int number){

        switch (number){
            case 1:
                System.out.println("--<전체 직원 조회>--");

                for(Map<Integer, String> employee :  employeeDAO.selectAllEmp(getConnection())){
                    System.out.println(employee);
                }

                break;
            case 2:
                System.out.println("--<직원 상세 조회>--");
                System.out.println("조회할 직원 ID를 입력해주세요.");
                int empNum = sc.nextInt();
                System.out.println(employeeDAO.selectByIdEmp(getConnection(), empNum));
                break;
            case 3:
                System.out.println("--<직원 등록>--");
                EmployeeDTO employeeDTO = new EmployeeDTO();
                System.out.print("ID:");
                employeeDTO.setId(sc.nextInt());
                sc.nextLine();
                System.out.print("이름:");
                employeeDTO.setName(sc.nextLine());
                System.out.print("사번:");
                employeeDTO.setEmpNumber(sc.nextLine());
                System.out.print("직업 코드:");
                employeeDTO.setJobCode(sc.nextLine());
                System.out.print("급여 레벨:");
                employeeDTO.setSalLevel(sc.nextLine());

                System.out.println(employeeDAO.insertEmp(getConnection(), employeeDTO) > 0 ? "직원 등록 성공!": "직원 등록 실패");

                break;
            case 4:
                System.out.println("--<직원 수정>--");
                System.out.print("수정할 직원 ID :");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("수정할 이름 :");
                String name = sc.nextLine();
                System.out.print("수정할 전화번호 :");
                String phone = sc.nextLine();
                System.out.print("수정할 급여 :");
                int salary = sc.nextInt();
                sc.nextLine();


                System.out.println(employeeDAO.modifyEmp(getConnection(), id, name, phone,salary) > 0 ? "수정 완료": "수정 실패");
                break;
            case 5:
                System.out.println("--<직원 삭제>--");
                System.out.print("삭제할 직원 ID :");
                System.out.println( employeeDAO.deleteEmp(getConnection(), sc.nextInt()) > 0 ? "삭제 완료!" : "삭제 실패");
                sc.nextLine();
                break;
            default:
                System.out.println("잘못된 입력 값입니다.");
        }

    }










}
