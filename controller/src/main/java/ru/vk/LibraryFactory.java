package ru.vk;

import org.jetbrains.annotations.NotNull;

public final class LibraryFactory
{
  public @NotNull Library createLibrary()
  {
    Library library = new Library();
    LibraryFiller libraryFiller = new LibraryFiller();
    library.setBooks(libraryFiller.fill());
    return library;
  }
}
