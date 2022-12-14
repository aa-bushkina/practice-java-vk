package ru.vk;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class Book
{
  @NonNull
  final String name;

  @NonNull
  final Author author;
}
