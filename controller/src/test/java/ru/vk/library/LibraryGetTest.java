package ru.vk.library;

import com.google.inject.Inject;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import ru.vk.Book;
import ru.vk.books.FileBooksFactory;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class LibraryGetTest extends LibraryTest
{
  @Inject
  @NotNull
  private LibraryFactory libraryFactory;
  @NotNull
  private final String filePath = "../controller/src/test/resources/books.txt";

  @Test
  @DisplayName("Вывод информации при взятии книги")
  void getBookFromCellAndPrintTest()
  {
    PrintStream stream = mock(PrintStream.class);
    ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
    System.setOut(stream);

    libraryFactory.library(3, filePath).takeBook(0);


    verify(stream, times(2)).println(captor.capture());
    List<String> list = new ArrayList<>();
    list.add("cell number: 0");
    list.add("""
      {
        "name": "Book 0",
        "author": {
          "name": "Author0"
        }
      }""");
    assertEquals(list, captor.getAllValues());
  }

  @Test
  @DisplayName("Взятие книги из пустой ячейки")
  void getBookFromEmptyCellTest()
  {
    LibraryImpl library = libraryFactory.library(3, filePath);
    library.takeBook(0);
    Throwable thrown = assertThrows(RuntimeException.class, () ->
    {
      library.takeBook(0);
    });
    assertEquals("The cell is empty", thrown.getMessage());
  }

  @Test
  @DisplayName("Взятие книги из ячейки")
  void getCorrectBookFromCellTest()
  {
    //Book bookExp = Mockito.mock(Book.class);
    LibraryImpl library = libraryFactory.library(3, filePath);
    Book book = library.takeBook(0);
    // assertEquals(bookExp, book);
  }
}
