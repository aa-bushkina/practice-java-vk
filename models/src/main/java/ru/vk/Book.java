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
  @Expose
  final String name;

  @Expose
  @SerializedName("year of publication")
  final int publicationYear;

  @NonNull
  final Author author;
}
