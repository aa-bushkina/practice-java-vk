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

    boolean isAuthorExist = false;
    while (true)
    {
      if (isAuthorExist)
      {
        return;
      }
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
            isAuthorExist = true;
            System.out.println("Книги автора: " + authorSurname);
          }
          Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .setPrettyPrinting()
            .create();
          String json = gson.toJson(book);
          System.out.println(json);
        }
      }
      if (!isAuthorExist)
      {
        System.out.println("В библиотеке нет автора: " + authorSurname + "\n");
      }
    }
  }

  public static String readSurnameFromInput()
  {
    System.out.println("Введите фамилию автора:");
    try (Scanner in = new Scanner(System.in))
    {
      final String str = in.nextLine();
      return str.replaceAll(" ", "");
    } catch (IllegalStateException | NoSuchElementException e)
    {
      e.printStackTrace();
    }
    return null;
  }
}
