# practice-java-vk
The Library project using several modules in the Gradle build system
The goal of the project is to learn how to create projects consisting of several modules, to study the structure of the project in Gradle, how to connect external dependencies and project modules, to learn how to assemble applications ready for installation on the server.

The library project consists of the modules models and controller.
The project in each module establishes a dependency on
com.intellij:annotations:12.0.
The variables group and version are defined and set for all modules.

The models module contains the “Author” and “Book" entity models. The “Author” and “Book” models use the Lombok library and do not contain any code other than field descriptions.
For correct operation, the Lombok plugin must be installed and configured in the IDE.


The controller module consists of classes: “Application”, which is the main class of the console application, ”Library” and “Library Factory”, which creates an instance of the library. The “library” contains books that are added to it.
The console application accepts an input parameter - the last name of the author of the book and displays a list of books written by him and available in the library. Books are output to the console, information about the book is output as a json-serialized class. The Gson library is used for serialization.