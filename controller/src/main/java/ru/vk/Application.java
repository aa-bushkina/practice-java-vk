package ru.vk;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.jetbrains.annotations.NotNull;
import ru.vk.books.BooksModule;

public final class Application
{
  public static void main(@NotNull String[] args)
  {
    String filename = args[0];
    int capacity = Integer.parseInt(args[1]);

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    Injector injector = Guice.createInjector(new BooksModule());
    Library library = injector.getInstance(LibraryFactory.class).library(capacity, filename);

    for (Book book : library.getBooks())
    {
      System.out.println(gson.toJson(book));
    }
  }
}
