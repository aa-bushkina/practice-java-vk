package ru.vk;

import com.google.inject.Inject;
import lombok.Data;
import org.jetbrains.annotations.NotNull;
import ru.vk.books.BooksFactory;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Data
public final class Library
{
  private List<Book> books;
  @NotNull
  private BooksFactory booksFactory;
  private int capacity;

  @Inject
  Library(@NotNull final @Named("file") BooksFactory booksFactory, final int capacity)
  {
    this.booksFactory = booksFactory;
    this.capacity = capacity;
    books = (ArrayList<Book>) booksFactory.books();
  }

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
