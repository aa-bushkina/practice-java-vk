package ru.vk.library;

import java.util.ArrayList;
import java.util.List;

public class Utils
{
  public static List<String> makeExpectedListForPrintTest()
  {
    List<String> list = new ArrayList<>();
    list.add("cell number: 0");
    list.add("""
      {
        "name": "Book 0",
        "author": {
          "name": "Author0"
        }
      }""");
    list.add("cell number: 1");
    list.add("""
      {
        "name": "Book 1",
        "author": {
          "name": "Author0"
        }
      }""");
    return list;
  }

  public static List<String> makeExpectedListForGetTest()
  {
    List<String> list = new ArrayList<>();
    list.add("cell number: 0");
    list.add("""
      {
        "name": "Book 0",
        "author": {
          "name": "Author0"
        }
      }""");
    return list;
  }
}
