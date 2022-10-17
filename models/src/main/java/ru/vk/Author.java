package ru.vk;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Value;

@Value
@AllArgsConstructor
public class Author
{
  @NonNull
  String surname;
  String firstname;
  String patronymic;

  @NonNull
  String country;
}
