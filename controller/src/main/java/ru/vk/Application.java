package ru.vk;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jetbrains.annotations.NotNull;

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

    boolean isAuthorExist;
    System.out.println("Нажмите Ctrl+D для выхода");
    while (true)
    {
      isAuthorExist = false;
      final String authorSurname = readSurnameFromInput();
      if (authorSurname.isEmpty())
      {
        continue;
      }

      for (Book book : library.getBooks())
      {
        if (authorSurname.equalsIgnoreCase(book.getAuthor().getSurname()))
        {
          if (!isAuthorExist)
          {
            System.out.println("Книги автора: " + authorSurname);
          }
          isAuthorExist = true;
          String json = gson.toJson(book);
          System.out.println(json);
        }
      }
      if (!isAuthorExist)
      {
        System.out.println("В библиотеке нет автора: " + authorSurname);
      }
      System.out.println('\n');
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
