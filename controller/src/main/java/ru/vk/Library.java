package ru.vk;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.inject.Inject;
import lombok.Data;
import org.jetbrains.annotations.NotNull;
import ru.vk.books.BooksFactory;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

public final class Library
{
  private List<Book> books;
  private final int capacity;
  @NotNull
  private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

  @Inject
  Library(@NotNull final @Named("file") BooksFactory booksFactory, final int capacity)
  {
    this.capacity = capacity;
    books = new ArrayList<>(capacity);
    if (booksFactory.books().size() > capacity)
    {
      throw new RuntimeException("The allowed container size has been exceeded");
    }
    books = (ArrayList<Book>) booksFactory.books();
  }

  public Book takeBook(final int cellNum)
  {
    if (cellNum > capacity || cellNum < 0)
    {
      throw new RuntimeException("Invalid cell number");
    }
    System.out.println("cell number: " + cellNum);
    if (books.get(cellNum) == null)
    {
      throw new RuntimeException("The cell is empty");
    }
    Book tmpBook = books.get(cellNum);
    books.set(cellNum, null);
    printBook(tmpBook);
    return tmpBook;
  }

  public void addBook(@NotNull final Book book)
  {
    for (int i = 0; i < books.size(); i++)
    {
      if (books.get(i) == null)
      {
        books.set(i, book);
        return;
      }
    }
    throw new RuntimeException("The library is full");
  }

  public void printBook(@NotNull final Book book)
  {
    System.out.println(gson.toJson(book));
  }

  public void printAllBooks()
  {
    int cellNum = 0;
    for (Book book : books)
    {
      System.out.println("cell number: " + cellNum++);
      printBook(book);
    }
    System.out.println();
  }

  public List<Book> getBooksByAuthor(@NotNull final String authorSurname)
  {
    List<Book> booksByAuthor = new ArrayList<Book>();
    for (Book book : books)
    {
      if (authorSurname.equalsIgnoreCase(book.getAuthor().getName()))
      {
        booksByAuthor.add(book);
      }
    }
    return booksByAuthor;
  }
}
