package ru.vk.books;

import org.jetbrains.annotations.NotNull;
import ru.vk.Book;

import java.util.Collection;

public interface BooksFactory
{
  Collection<Book> books();

  void setFileName(@NotNull String fileName);

}
