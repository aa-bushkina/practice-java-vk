package ru.vk;

public class LibraryFactory
{
  public Library createLibrary()
  {
    Library library = new Library();
    LibraryFiller libraryFiller = new LibraryFiller();
    library.setBooks(libraryFiller.fill());
    return library;
  }
}
