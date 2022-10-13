package ru.vk;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class Author
{
  @NonNull
  private String surname;
  private String firstname;
  private String patronymic;
  @NonNull
  private String country;
}
