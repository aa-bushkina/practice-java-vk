package ru.vk;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@Data
public final class Library
{
  private List<Book> books;
}
