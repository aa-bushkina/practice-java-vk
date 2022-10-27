package ru.vk;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.jetbrains.annotations.NotNull;
import ru.vk.books.BooksModule;
import ru.vk.library.LibraryImpl;
import ru.vk.library.LibraryFactory;
import ru.vk.library.LibraryModule;

public final class Application
{
  public static void main(@NotNull String[] args)
  {
    final String filename = args[0];
    final int capacity = Integer.parseInt(args[1]);

    Injector injector = Guice.createInjector(new BooksModule(), new LibraryModule());
    LibraryImpl library = injector.getInstance(LibraryFactory.class).library(capacity, filename);
    library.printAllBooks();
  }
}
