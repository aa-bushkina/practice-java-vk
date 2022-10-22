package ru.vk;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@Data
public final class Library
{
  private List<Book> books;

  public List<Book> getBooksByAuthor(@NotNull final String authorSurname)
  {
    List<Book> booksByAuthor = new ArrayList<Book>();
    for (Book book : books)
    {
      if (authorSurname.equalsIgnoreCase(book.getAuthor().getSurname()))
      {
        booksByAuthor.add(book);
      }
    }
    return booksByAuthor;
  }
}
