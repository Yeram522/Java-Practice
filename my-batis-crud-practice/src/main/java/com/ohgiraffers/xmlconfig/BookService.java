package com.ohgiraffers.xmlconfig;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.xmlconfig.Template.getSqlSession;

public class BookService {

    private final BookDAO bookDAO;

    public BookService(){ bookDAO = new BookDAO();}

    public List<BookDTO> selectAllBook(){

        SqlSession sqlSession = getSqlSession();

        List<BookDTO> bookList = bookDAO.selectAllBook(sqlSession);

        sqlSession.close();

        return bookList;
    }


    public BookDTO selectBookByCode(int code) {
        SqlSession sqlSession = getSqlSession();

        BookDTO bookDTO = bookDAO.selectBookByCode(sqlSession, code);

        sqlSession.close();

        return bookDTO;
    }

    public boolean registBook(BookDTO book) {

        SqlSession sqlSession = getSqlSession();

        int result = bookDAO.insertMenu(sqlSession, book);

        if(result > 0){
            sqlSession.commit();
        }else{
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0 ? true : false;
    }

    public boolean modifyBook(BookDTO book) {
        SqlSession sqlSession = getSqlSession();

        int result = bookDAO.updateBook(sqlSession, book);

        if(result > 0){
            sqlSession.commit();
        }else{
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0 ? true : false;
    }

    public boolean deleteBookByCode(int code) {

        SqlSession sqlSession = getSqlSession();

        int result = bookDAO.deleteBookByCode(sqlSession, code);

        if(result > 0){
            sqlSession.commit();
        }else{
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0 ? true : false;
    }
}
