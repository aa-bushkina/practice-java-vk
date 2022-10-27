package ru.vk.books;

import lombok.NonNull;
import org.jetbrains.annotations.NotNull;
import ru.vk.Author;
import ru.vk.Book;

import java.util.ArrayList;

public final class StaticBooksFactory implements BooksFactory
{
  public @NonNull ArrayList<Book> books()
  {
    ArrayList<Book> bookList = new ArrayList<>();
    Author author1 =
      new Author("Пушкин Александр Сергеевич", "Россия");
    Author author2 =
      new Author("Шекспир Уильям", "Англия");
    Author author3 =
      new Author("Леру Гастон", "Франция");

    bookList.add(new Book("Пиковая дама", author1));
    bookList.add(new Book("Капитанская дочка", author1));
    bookList.add(new Book("Дубровский", author1));
    bookList.add(new Book("Медный всадник", author1));
    bookList.add(new Book("Гамлет", author2));
    bookList.add(new Book("Король Лир", author2));
    bookList.add(new Book("Призрак оперы", author3));

    return bookList;
  }

  @Override
  public void setFileName(@NotNull String fileName)
  {

  }
}
