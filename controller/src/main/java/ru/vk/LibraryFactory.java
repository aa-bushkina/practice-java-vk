package ru.vk;

import com.google.inject.Inject;
import org.jetbrains.annotations.NotNull;
import ru.vk.books.BooksFactory;
import ru.vk.books.FileBooksFactory;

import javax.inject.Named;

public class LibraryFactory
{
  Library library(final int capacity, @NotNull final String filename)
  {
    return new Library(new FileBooksFactory(filename), capacity);
  }
}
