package ru.vk.library;

import com.google.inject.Inject;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.vk.books.FileBooksFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LibraryCreateTest extends LibraryTest
{
  @Inject
  @NotNull
  private LibraryFactory libraryFactory;
  @NotNull
  private final String filePath = "../controller/src/test/resources/books.txt";
  @NotNull
  @Inject
  FileBooksFactory fileBooksFactory;

  @Test
  @DisplayName("Создание библиотеки с вместимостью меньше, чем количество книг, возвращаемых фабрикой")
  void exceedingCapacityOfLibraryTest() throws RuntimeException
  {
    Throwable thrown = assertThrows(RuntimeException.class, () ->
    {
      libraryFactory.library(1, filePath);
    });
    assertEquals("The allowed container size has been exceeded", thrown.getMessage());
  }

  @Test
  @DisplayName("При создании библиотеки все книги расставлены по ячейкам в порядке как возвращаются фабрикой книг")
  void fillCellsOfLibraryTest()
  {
    var a = fileBooksFactory.books(filePath);
    var b = libraryFactory.library(3, filePath).getBooks();
    assertEquals(a, b);
  }

}
