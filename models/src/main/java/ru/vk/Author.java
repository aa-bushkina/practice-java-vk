package ru.vk;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Value;

@Value
@AllArgsConstructor
public class Author
{
  @NonNull
  final String surname;
  final String firstname;
  final String patronymic;

  @NonNull
  final String country;
}
