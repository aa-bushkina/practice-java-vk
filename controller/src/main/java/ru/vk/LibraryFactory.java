package ru.vk;

import org.jetbrains.annotations.NotNull;
import ru.vk.books.FileBooksFactory;

public class LibraryFactory
{
  Library library(final int capacity, @NotNull final String filename)
  {
    return new Library(new FileBooksFactory(filename), capacity);
  }
}
