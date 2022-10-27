package ru.vk.library;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.assistedinject.*;

public class LibraryModule implements Module
{
  @Override
  public void configure(Binder binder)
  {
    binder.install(new FactoryModuleBuilder()
      .implement(Library.class, LibraryImpl.class)
      .build(LibraryFactory.class));
  }
}
