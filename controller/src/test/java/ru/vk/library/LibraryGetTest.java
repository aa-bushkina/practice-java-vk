package ru.vk.library;

import com.google.inject.Inject;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import ru.vk.Book;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class LibraryGetTest extends LibraryTest
{
  @Inject
  @NotNull
  private LibraryFactory libraryFactory;
  @NotNull
  private final String filePath = "../controller/src/test/resources/books.txt";
  final int capacity = 3;
  final int cellNum = 0;

  @Test
  @DisplayName("Вывод информации при взятии книги")
  void getBookFromCellAndPrintTest()
  {
    final int numOfPrintlnInMethod = 2;
    final PrintStream stream = mock(PrintStream.class);
    final ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
    System.setOut(stream);

    libraryFactory.library(capacity, filePath).takeBook(cellNum);

    verify(stream, times(numOfPrintlnInMethod)).println(captor.capture());
    assertThat(makeExpectedList(), is(equalTo(captor.getAllValues())));
  }

  @Test
  @DisplayName("Взятие книги из пустой ячейки")
  void getBookFromEmptyCellTest()
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
  void getCorrectBookFromCellTest()
  {
    final Book bookExpected = Mockito.mock(Book.class);
    when(bookExpected.getName()).thenReturn("Book 0");

    final LibraryImpl library = libraryFactory.library(capacity, filePath);
    final Book book = library.takeBook(cellNum);

    assertThat(bookExpected.getName(), is(equalTo(book.getName())));
  }

  List<String> makeExpectedList()
  {
    List<String> list = new ArrayList<>();
    list.add("cell number: 0");
    list.add("""
      {
        "name": "Book 0",
        "author": {
          "name": "Author0"
        }
      }""");
    return list;
  }
}
