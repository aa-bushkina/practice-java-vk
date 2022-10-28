package ru.vk.library;

import com.google.inject.Inject;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.vk.Book;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

public class LibraryAddTest extends LibraryTest
{
  @Inject
  @NotNull
  private LibraryFactory libraryFactory;
  @NotNull
  private final String filePath = "../controller/src/test/resources/books.txt";
  final int capacity = 2;

  @Test
  @DisplayName("Добавление книги в первую пустую ячейку")
  void addBookToFirstEmptyCellTest()
  {
    final LibraryImpl library = libraryFactory.library(capacity, filePath);
    library.takeBook(0);
    library.takeBook(1);
    library.addBook(Mockito.mock(Book.class));
    assertThat(library.getBooks().get(0), is(not(equalTo(null))));
    assertThat(library.getBooks().get(1), is(equalTo(null)));
  }

  @Test
  @DisplayName("Добавление книги в заполненную библиотеку")
  void addBookToFullLibraryTest()
  {
    final String expectedMsg = "The library is full";
    final LibraryImpl library = libraryFactory.library(capacity, filePath);
    final Throwable thrown = assertThrows(RuntimeException.class, () ->
      library.addBook(Mockito.mock(Book.class)));
    assertThat(expectedMsg, is(equalTo(thrown.getMessage())));
  }
}
