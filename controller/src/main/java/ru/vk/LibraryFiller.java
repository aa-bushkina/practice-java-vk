package ru.vk;

import java.util.ArrayList;

public final class LibraryFiller
{
  public ArrayList<Book> fill()
  {
    ArrayList<Book> bookList = new ArrayList<>();
    Author author1 =
      new Author("Пушкин", "Александр", "Сергеевич", "Россия");
    Author author2 =
      new Author("Шекспир", "Уильям", "", "Англия");
    Author author3 =
      new Author("Леру", "Гастон", "", "Франция");

    bookList.add(new Book("Пиковая дама", 1833, author1));
    bookList.add(new Book("Капитанская дочка", 1836, author1));
    bookList.add(new Book("Дубровский", 1841, author1));
    bookList.add(new Book("Медный всадник", 1833, author1));
    bookList.add(new Book("Гамлет", 1623, author2));
    bookList.add(new Book("Король Лир", 1608, author2));
    bookList.add(new Book("Призрак оперы", 1910, author3));

    return bookList;
  }
}
