package ru.vk.library;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import ru.vk.books.BooksModule;

public abstract class AbstractTest
{
  @BeforeEach
  public void beforeEach()
  {
    Injector injector = Guice.createInjector(new BooksModule(), new LibraryModule());
    injector.injectMembers(this);
  }
}

