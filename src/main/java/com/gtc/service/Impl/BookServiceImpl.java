package com.gtc.service.Impl;

import com.gtc.DAO.BookDAO;
import com.gtc.DAO.Impl.BookDAOImpl;
import com.gtc.entity.Books;
import com.gtc.service.BooksService;
import com.gtc.utils.DBUtils;

import java.util.List;

public class BookServiceImpl implements BooksService {

    private static final BookDAO boo = new BookDAOImpl();
    @Override
    public List<Books> findALLBooks() {
        try {
            DBUtils.Begin();
            List<Books> books = boo.selectALLBooks();
            DBUtils.Commit();
            return books;
        } catch (Exception e) {
            e.printStackTrace();
            DBUtils.Rollback();
        }
        return null;
    }

    @Override
    public Books findBookById(Integer id) {
        try {
            DBUtils.Begin();
            Books book = boo.selectBookById(id);
            DBUtils.Commit();
            return book;
        } catch (Exception e) {
            e.printStackTrace();
            DBUtils.Rollback();
        }
        return null;
    }

    @Override
    public void modifyBookById(Books books) {
        try {
            DBUtils.Begin();
            System.out.println(boo.updateBookById(books));
            DBUtils.Commit();
        } catch (Exception e) {
            e.printStackTrace();
            DBUtils.Rollback();
        }
    }

    @Override
    public void saveBook(Books books) {
        try {
            DBUtils.Begin();
            System.out.println(boo.insertBook(books));
            DBUtils.Commit();
        } catch (Exception e) {
            e.printStackTrace();
            DBUtils.Rollback();
        }
    }

    @Override
    public void delBookById(Integer id) {
        try {
            DBUtils.Begin();
            System.out.println(boo.deleteBookById(id));
            DBUtils.Commit();
        } catch (Exception e) {
            e.printStackTrace();
            DBUtils.Rollback();
        }
    }
}
