package ru.vk;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class FileBooksFactory implements BooksFactory
{
  @NotNull
  private static final Type listBooksType = new TypeToken<ArrayList<Book>>()
  {
  }.getType();

  @NotNull
  private final String fileName;

  public FileBooksFactory(@NotNull String fileName)
  {
    this.fileName = fileName;
  }

  @NotNull
  @Override
  public ArrayList<Book> books()
  {
    try
    {
      return new Gson().fromJson(new BufferedReader(new FileReader(fileName)), listBooksType);
    } catch (FileNotFoundException e)
    {
      throw new IllegalStateException(e);
    }
  }
}
