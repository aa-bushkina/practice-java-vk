package ru.vk;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@Data
public final class Library
{
  private List<Book> books;

  public void addBook(final @NotNull Book book)
  {
    if (!books.contains(book))
    {
      books.add(book);
    }
  }

  public void deleteBook(final @NotNull Book book)
  {
    books.remove(book);
  }

}
