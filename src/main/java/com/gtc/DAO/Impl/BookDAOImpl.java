package com.gtc.DAO.Impl;

import com.gtc.DAO.BookDAO;
import com.gtc.entity.Books;
import com.gtc.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAOImpl implements BookDAO {
    private final Connection conn = DBUtils.getConnection();
    @Override
    public List<Books> selectALLBooks() throws SQLException {
        String sql = "select * from t_book;";
        assert conn != null;
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        List<Books> books= new ArrayList<>();
        while (resultSet.next()) {
            Books book = new Books();
            book.setId(resultSet.getInt("id"));
            book.setName(resultSet.getString("name"));
            book.setPrice(resultSet.getInt("price"));
            book.setAuthor(resultSet.getString("author"));
            books.add(book);
        }
        return books;
    }

    @Override
    public Books selectBookById(Integer id) throws SQLException {
        String sql = "select * from t_book where id=?;";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1,id);
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        Books book = new Books();
        book.setId(resultSet.getInt("id"));
        book.setName(resultSet.getString("name"));
        book.setPrice(resultSet.getInt("price"));
        book.setAuthor(resultSet.getString("author"));
        return book;
    }

    @Override
    public int updateBookById(Books books) throws SQLException {
        String sql = "update t_book set name=?,price=?,author=? where id=?;";
        assert conn != null;
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,books.getName());
        statement.setInt(2, books.getPrice());
        statement.setString(3,books.getAuthor());
        statement.setInt(4,books.getId());
        return statement.executeUpdate();

    }

    @Override
    public int insertBook(Books books) throws SQLException {
        String sql = "insert into t_book (name, price, author) values (?,?,?);";
        assert conn != null;
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,books.getName());
        statement.setInt(2, books.getPrice());
        statement.setString(3,books.getAuthor());
        return statement.executeUpdate();
    }

    @Override
    public int deleteBookById(Integer id) throws SQLException {
        String sql = "delete from t_book where id=?;";
        assert conn != null;
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1,id);
        return statement.executeUpdate();
    }
}
