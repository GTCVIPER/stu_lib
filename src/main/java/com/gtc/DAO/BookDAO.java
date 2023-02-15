package com.gtc.DAO;

import com.gtc.entity.Books;

import java.sql.SQLException;
import java.util.List;

public interface BookDAO {
    List<Books> selectALLBooks() throws SQLException;

    Books selectBookById(Integer id) throws SQLException;

    int updateBookById(Books books) throws SQLException;

    int insertBook(Books books) throws SQLException;

    int deleteBookById(Integer id) throws SQLException;
}
