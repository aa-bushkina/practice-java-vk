package ru.vk.library;

import com.google.inject.Inject;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.vk.Book;
import ru.vk.books.FileBooksFactory;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryAddTest extends LibraryTest
{
  @Inject
  @NotNull
  private LibraryFactory libraryFactory;
  @NotNull
  private final String filePath = "../controller/src/test/resources/books.txt";

  @Test
  @DisplayName("Добавление книги в первую пустую ячейку")
  void addBookToFirstEmptyCellTest()
  {
    LibraryImpl library = libraryFactory.library(3, filePath);
    library.takeBook(0);
    //library.addBook(Mockito.mock(Book.class));
    assertNotEquals(library.takeBook(0), null);
  }

  @Test
  @DisplayName("Добавление книги в заполненную библиотеку")
  void addBookToFullLibraryTest()
  {
    LibraryImpl library = libraryFactory.library(3, filePath);
    library.addBook(Mockito.mock(Book.class));
    Throwable thrown = assertThrows(RuntimeException.class, () ->
    {
      library.addBook(Mockito.mock(Book.class));
    });
    assertEquals("The library is full", thrown.getMessage());
  }
}
