package ru.vk.library;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.lang.annotation.Annotation;

public class Extension implements BeforeAllCallback, AfterAllCallback
{

  @Override
  public void afterAll(ExtensionContext context) throws Exception
  {

  }

  @Override
  public void beforeAll(ExtensionContext context) throws Exception
  {

  }
}
