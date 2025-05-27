package com.ohgiraffers.xmlconfig;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class BookDAO {

    public List<BookAndAuthorDTO> selectAllBook(SqlSession sqlSession){
        return sqlSession.selectList("BookMapper.selectAllBook");
    }

    public BookDTO selectBookByCode(SqlSession sqlSession, int code) {
        return sqlSession.selectOne("BookMapper.selectMenuByCode", code);
    }

    public int insertMenu(SqlSession sqlSession, BookDTO book) {
        return sqlSession.insert("BookMapper.insertBook", book);
    }

    public int updateBook(SqlSession sqlSession, BookDTO book) {

        return sqlSession.update("BookMapper.updateBook", book);
    }

    public int deleteBookByCode(SqlSession sqlSession, int code) {
        return  sqlSession.delete("BookMapper.deleteBook", code);
    }
}
