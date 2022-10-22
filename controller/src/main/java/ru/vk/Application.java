package ru.vk;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public final class Application
{
  public static void main(@NotNull String[] args)
  {
    final LibraryFactory libFactory = new LibraryFactory();
    final Library library = libFactory.createLibrary();

    Gson gson = new GsonBuilder()
      .excludeFieldsWithoutExposeAnnotation()
      .setPrettyPrinting()
      .create();

    System.out.println("Нажмите Ctrl+D для выхода");
    while (true)
    {
      final String authorSurname = readSurnameFromInput();
      if (authorSurname.isEmpty())
      {
        continue;
      }
      List<Book> booksByAuthor = library.getBooksByAuthor(authorSurname);
      if (booksByAuthor.isEmpty())
      {
        System.out.println("В библиотеке нет книг автора: " + authorSurname + "\n");
        continue;
      }
      System.out.println("Книги автора: " + authorSurname);

      for (Book book : booksByAuthor)
      {
        System.out.println(gson.toJson(book));
      }
      System.out.println();
    }
  }

  public static String readSurnameFromInput()
  {
    System.out.println("Введите фамилию автора:");
    Scanner in = new Scanner(System.in);
    final String str = in.nextLine();
    return str.replaceAll(" ", "");
  }
}
