package ru.vk.books;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.jetbrains.annotations.NotNull;
import ru.vk.Book;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

public final class FileBooksFactory implements BooksFactory
{
  @NotNull
  private final Type listBooksType = new TypeToken<ArrayList<Book>>()
  {
  }.getType();

  @Override
  public ArrayList<Book> books(@NotNull final String filePath)
  {
    try
    {
      return new Gson().fromJson(new BufferedReader(new FileReader(filePath)), listBooksType);
    } catch (FileNotFoundException e)
    {
      throw new IllegalStateException(e);
    }
  }
}
