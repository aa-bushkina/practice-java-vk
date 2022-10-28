package ru.vk.library;

import com.google.inject.Inject;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;


class PrintLibraryTest extends LibraryTest
{
  @Inject
  @NotNull
  private LibraryFactory libraryFactory;
  @NotNull
  private final String filePath = "../controller/src/test/resources/books.txt";
  final int capacity = 3;
  final int numBooksInFile = 2;

  @Test
  @DisplayName("Вывод информации о всех книгах")
  void printAllBooksTest()
  {
    PrintStream stream = mock(PrintStream.class);
    ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
    System.setOut(stream);

    libraryFactory.library(capacity, filePath).printAllBooks();

    verify(stream, times(numBooksInFile * 2)).println(captor.capture());

    assertEquals(makeExpectedList(), captor.getAllValues());
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
    list.add("cell number: 1");
    list.add("""
      {
        "name": "Book 1",
        "author": {
          "name": "Author0"
        }
      }""");
    return list;
  }
}