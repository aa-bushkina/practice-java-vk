package ru.vk;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class Book
{
  @NonNull
  @Expose
  private String name;
  @Expose
  @SerializedName("year of publication")
  private int publicationYear;
  @NonNull
  private Author author;
}
