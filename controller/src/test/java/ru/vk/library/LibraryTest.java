package ru.vk.library;

import com.google.inject.Inject;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import ru.vk.Book;
import ru.vk.books.FileBooksFactory;

import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static ru.vk.library.Utils.makeExpectedListForGetTest;
import static ru.vk.library.Utils.makeExpectedListForPrintTest;

public class LibraryTest extends AbstractTest
{
  @Inject
  @NotNull
  private LibraryFactory libraryFactory;

  @NotNull
  @Inject
  FileBooksFactory fileBooksFactory;

  @NotNull
  private final String filePath = "../controller/src/test/resources/books.txt";
  final int capacity = 2;
  final int capacityLess = 1;
  final int cellNum = 0;
  final int numBooksInFile = 2;
  final int numOfPrintlnInMethod = 2;

  @Test
  @DisplayName("Создание библиотеки с вместимостью меньше, чем количество книг, возвращаемых фабрикой")
  void exceedingCapacityOfLibrary() throws RuntimeException
  {
    final String expectedMsg = "The allowed container size has been exceeded";
    final Throwable thrown = assertThrows(RuntimeException.class, () ->
      libraryFactory.library(capacityLess, filePath));
    assertThat(expectedMsg, is(equalTo(thrown.getMessage())));
  }

  @Test
  @DisplayName("При создании библиотеки все книги расставлены по ячейкам в порядке как возвращаются фабрикой книг")
  void fillCellsOfLibrary()
  {
    assertThat(fileBooksFactory.books(filePath),
      is(equalTo(libraryFactory.library(capacity, filePath).getBooks())));
  }

  @Test
  @DisplayName("Вывод информации при взятии книги")
  void getBookFromCellAndPrint()
  {
    final int numOfPrintlnInMethod = 2;
    final PrintStream stream = mock(PrintStream.class);
    final ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
    System.setOut(stream);

    libraryFactory.library(capacity, filePath).takeBook(cellNum);

    verify(stream, times(numOfPrintlnInMethod)).println(captor.capture());
    assertThat(makeExpectedListForGetTest(), is(equalTo(captor.getAllValues())));
  }

  @Test
  @DisplayName("Взятие книги из пустой ячейки")
  void getBookFromEmptyCell()
  {
    final String expectedMsg = "The cell is empty";
    final LibraryImpl library = libraryFactory.library(capacity, filePath);
    library.takeBook(cellNum);

    final Throwable thrown = assertThrows(RuntimeException.class, () ->
      library.takeBook(cellNum));

    assertThat(expectedMsg, is(equalTo(thrown.getMessage())));
  }

  @Test
  @DisplayName("Взятие книги из ячейки")
  void getCorrectBookFromCell()
  {
    final Book bookExpected = Mockito.mock(Book.class);
    when(bookExpected.getName()).thenReturn("Book 0");

    final LibraryImpl library = libraryFactory.library(capacity, filePath);
    final Book book = library.takeBook(cellNum);

    assertThat(bookExpected.getName(), is(equalTo(book.getName())));
  }

  @Test
  @DisplayName("Добавление книги в первую пустую ячейку")
  void addBookToFirstEmptyCell()
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
  void addBookToFullLibrary()
  {
    final String expectedMsg = "The library is full";
    final LibraryImpl library = libraryFactory.library(capacity, filePath);
    final Throwable thrown = assertThrows(RuntimeException.class, () ->
      library.addBook(Mockito.mock(Book.class)));
    assertThat(expectedMsg, is(equalTo(thrown.getMessage())));
  }

  @Test
  @DisplayName("Вывод информации о всех книгах")
  void printAllBooks()
  {
    final PrintStream stream = mock(PrintStream.class);
    final ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
    System.setOut(stream);

    libraryFactory.library(capacity, filePath).printAllBooks();

    verify(stream, times(numBooksInFile * numOfPrintlnInMethod)).println(captor.capture());

    assertEquals(makeExpectedListForPrintTest(), captor.getAllValues());
  }


}

