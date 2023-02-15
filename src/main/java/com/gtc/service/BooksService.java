package com.gtc.service;

import com.gtc.entity.Books;

import java.util.List;

public interface BooksService {

    List<Books> findALLBooks();

    Books findBookById(Integer id);

    void modifyBookById(Books books);

    void saveBook(Books books);

    void delBookById(Integer id);

}
