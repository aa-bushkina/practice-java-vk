package ru.vk.library;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import ru.vk.Book;
import ru.vk.books.BooksFactory;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Getter
public final class LibraryImpl implements Library
{
  private List<Book> books;
  @NotNull
  private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
  private TreeSet<Integer> emptyIndexes;

  @AssistedInject
  LibraryImpl(@NotNull @Named("file") BooksFactory factory,
              @Assisted final int capacity,
              @Assisted @NotNull final String filePath)
  {
    final ArrayList<Book> tmpBooks = (ArrayList<Book>) factory.books(filePath);
    books = new ArrayList<>(capacity);
    if (tmpBooks.size() > capacity)
    {
      throw new RuntimeException("The allowed container size has been exceeded");
    }
    books = tmpBooks;
    emptyIndexes = new TreeSet<>();
    for (int i = tmpBooks.size(); i < books.size(); i++)
    {
      emptyIndexes.add(i);
    }
  }

  public Book takeBook(final int cellNum)
  {
    if (cellNum > books.size() || cellNum < 0)
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
    emptyIndexes.add(cellNum);
    printBook(tmpBook);
    return tmpBook;
  }

  public void addBook(@NotNull final Book book)
  {
    if (emptyIndexes.isEmpty())
    {
      throw new RuntimeException("The library is full");
    }
    books.add(emptyIndexes.first(), book);
    emptyIndexes.remove(emptyIndexes.first());
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
}
