package ru.vk;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Value;
import org.jetbrains.annotations.Nullable;

@Value
@AllArgsConstructor
public class Author
{
  @NonNull
  final String surname;
  @Nullable
  final String firstname;
  @Nullable
  final String patronymic;
  @NonNull
  final String country;
}
