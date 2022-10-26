package ru.vk.books;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class BooksModule extends AbstractModule
{
  @Override
  protected void configure()
  {
    bind(BooksFactory.class).annotatedWith(Names.named("file")).to(FileBooksFactory.class);
    bind(BooksFactory.class).annotatedWith(Names.named("static")).to(StaticBooksFactory.class);
  }
}
