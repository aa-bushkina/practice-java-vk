package ru.vk.library;

import org.jetbrains.annotations.NotNull;
import ru.vk.Book;


import java.util.List;

public interface Library
{
  void addBook(@NotNull final Book book);

  void printBook(@NotNull final Book book);

  void printAllBooks();
}

