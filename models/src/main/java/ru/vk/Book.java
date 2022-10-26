package ru.vk;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Value;

@Value
@AllArgsConstructor
public class Book
{
  @NonNull
  final String name;

  @NonNull
  final Author author;
}
