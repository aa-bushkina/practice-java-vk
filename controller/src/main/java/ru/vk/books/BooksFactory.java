package ru.vk.books;

import ru.vk.Book;

import java.util.Collection;

public interface BooksFactory
{
  Collection<Book> books();
}
