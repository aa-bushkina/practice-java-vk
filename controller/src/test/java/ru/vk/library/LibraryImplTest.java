package ru.vk.library;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(Extension.class)
class LibraryImplTest
{
  @Test
  @DisplayName("Создание библиотеки с вместимостью меньше, чем количество книг, возвращаемое фабрикой")
  void exceedingCapacityOfLibraryTest()
  {

  }

  @Test
  @DisplayName("При создании библиотеки все книги расставлены по ячейкам в порядке как возвращаются фабрикой книг")
  void fillCellsOfLibraryTest()
  {
  }

  @Test
  @DisplayName("Вывод информации при взятии книги")
  void getBookFromCellAndPrintTest()
  {

  }

  @Test
  @DisplayName("Взятие книги из пустой яччейки")
  void getBookFromEmptyCellTest()
  {

  }

  @Test
  @DisplayName("Взятие книги из ячейки")
  void getCorrectBookFromCellTest()
  {

  }

  @Test
  @DisplayName("Добавление книги в первую пустю ячейку")
  void addBookToFirstEmptyCellTest()
  {

  }

  @Test
  @DisplayName("Добавление книги в заполненную библиотеку")
  void addBookToFullLibraryTest()
  {

  }

  @Test
  @DisplayName("Вывод информации о всех книгах")
  void printAllBooksTest()
  {

  }
}