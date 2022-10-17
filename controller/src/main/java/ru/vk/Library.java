package ru.vk;

import lombok.Data;

import java.util.ArrayList;

@Data
public final class Library
{
  private ArrayList<Book> books;

  public void addBook(Book book)
  {
    if (!books.contains(book))
    {
      books.add(book);
    }
  }

  public void deleteBook(Book book)
  {
    books.remove(book);
  }

}
