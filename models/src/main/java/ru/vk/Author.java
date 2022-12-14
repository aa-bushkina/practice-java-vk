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
  final String name;
  @Nullable
  final String country;
}
