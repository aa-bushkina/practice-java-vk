package ru.vk;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
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
