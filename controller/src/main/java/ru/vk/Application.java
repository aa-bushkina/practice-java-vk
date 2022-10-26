package ru.vk;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.jetbrains.annotations.NotNull;
import ru.vk.books.BooksModule;

public final class Application
{
  public static void main(@NotNull String[] args)
  {
    final String filename = args[0];
    final int capacity = Integer.parseInt(args[1]);

    Injector injector = Guice.createInjector(new BooksModule());
    Library library = injector.getInstance(LibraryFactory.class).library(capacity, filename);

    library.printAllBooks();
  }
}
