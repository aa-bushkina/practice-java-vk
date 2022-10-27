package ru.vk.books;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import ru.vk.Book;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

@Setter
@Getter
public final class FileBooksFactory implements BooksFactory
{
  @NotNull
  private final Type listBooksType = new TypeToken<ArrayList<Book>>()
  {
  }.getType();

  @NotNull
  private String fileName;

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

  public void setFileName(@NotNull String fileName)
  {
    this.fileName = fileName;
  }
}
