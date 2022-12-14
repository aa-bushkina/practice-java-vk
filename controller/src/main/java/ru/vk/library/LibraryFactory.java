package ru.vk.library;

import org.jetbrains.annotations.NotNull;

public interface LibraryFactory
{
  LibraryImpl library(final int capacity, @NotNull final String filePath);
}
