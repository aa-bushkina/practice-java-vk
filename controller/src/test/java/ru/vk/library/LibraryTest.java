package ru.vk.library;

import com.google.inject.Guice;
import com.google.inject.Injector;
import net.bytebuddy.implementation.Implementation;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import ru.vk.books.BooksModule;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public abstract class LibraryTest
{
  @NotNull
  private final String filePath = "../controller/src/test/resources/books.txt";

  @BeforeEach
  public void beforeEach() throws IOException
  {
    Injector injector = Guice.createInjector(new BooksModule(), new LibraryModule());
    injector.injectMembers(this);

    String text = """
      [
      {
          "author": {
            "name": "Author0"
          },
          "name": "Book 0"
        },
        {
          "author": {
            "name": "Author0"
          },
          "name": "Book 1"
        }
      ]""";
    FileOutputStream out = new FileOutputStream(filePath, false);
    out.write(text.getBytes());
    out.close();
  }
}

